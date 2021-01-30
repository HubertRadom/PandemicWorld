package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Intersection {

    private Position downLeftCorner;
    private Position upRightCorner;
    private ArrayList<ClientThread> clientThreadList;
    private ArrayList<SupplierThread> supplierThreadList;
    private boolean available = true;
    private Intersection thisInter = this;

    Intersection(Position dl, Position ur, ArrayList<SupplierThread> suppliterThreadList, ArrayList<ClientThread> clientThreadList) {
        downLeftCorner = dl;
        upRightCorner = ur;
        this.clientThreadList = clientThreadList;
        this.supplierThreadList = suppliterThreadList;
        DeadlockDetector dead = new DeadlockDetector();
        dead.start();
    }

    /**
     * Checks if person is on intersection.
     *
     * @param pos position of client / supplier
     *
     */
    public boolean atIntersection(Position pos) {
        if (pos.getX() < downLeftCorner.getX() || pos.getX() > upRightCorner.getX()) {
            return false;
        }
        if (pos.getY() > downLeftCorner.getY() || pos.getY() < upRightCorner.getY()) {
            return false;
        }
        return true;
    }

    /**
     * Allows only one person to enter intersection.
     */
    public synchronized void enter() {
        while (available == false) {
            try {
                wait();

            } catch (InterruptedException e) {
            }
        }
        available = false;
        notifyAll();
    }

    /**
     * Free up space on intersection.
     */
    public synchronized void leave() {
        available = true;
        try {
            sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(Intersection.class.getName()).log(Level.SEVERE, null, ex);
        }
        notifyAll();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    /**
     * Deletes object on intersection when nothing changes after 10 seconds.
     */
    class DeadlockDetector extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    double start = System.currentTimeMillis();
                    double finish = System.currentTimeMillis();

                    while (available == false) {
                        if (finish - start > 10000) {
                            for (ClientThread c : clientThreadList) {
                                if (c.getClient().getCurrentIntersection() == thisInter && c.getClient().getAtIntersection()) {
                                    c.stop();
                                    c.getIcon().setVisible(false);
                                    c.getClient().resetPosition();
                                    leave();

                                }
                            }
                            for (SupplierThread s : supplierThreadList) {
                                if (s.getSupplier().getCurrentIntersection() == thisInter && s.getSupplier().getAtIntersection()) {
                                    s.stop();
                                    s.getIcon().setVisible(false);
                                    s.getSupplier().resetPosition();
                                    leave();
                                }
                            }
                            available = true;

                        }
                        finish = System.currentTimeMillis();
                        sleep(3);
                    }

                    sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Intersection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

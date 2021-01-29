package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Intersection {
    //private Position position;
    private Position downLeftCorner;
    private Position upRightCorner;
    private ArrayList<ClientThread>clientThreadList;
    private ArrayList<SupplierThread>supplierThreadList;
    private boolean available = true;
    private Intersection thisInter = this;
    
    Intersection(Position dl, Position ur, ArrayList<SupplierThread>suppliterThreadList, ArrayList<ClientThread>clientThreadList) {
       // position = p;
        downLeftCorner = dl;
        upRightCorner = ur;
        this.clientThreadList = clientThreadList;
        this.supplierThreadList = suppliterThreadList;
        DeadlockDetector dead = new DeadlockDetector();
        dead.start();
    }
    
    public Position getDL(){
        return downLeftCorner;
    }
    //public Position getPosition(){
    //    return position;
    //}
    public boolean atIntersection(Position pos){
        if(pos.getX() <  downLeftCorner.getX() || pos.getX() >  upRightCorner.getX()){
            return false;
        }
        if(pos.getY() >  downLeftCorner.getY() || pos.getY() <  upRightCorner.getY()){
            return false;
        }
        return true;
    }
    
    public synchronized void enter() {
        while (available == false) {
           try {
              wait();
              
           } catch (InterruptedException e) {}
        }
        //System.out.println("enter");
        //sleep(1000);
        
        available = false;
        notifyAll();
    }
    public synchronized void leave() {
      //while (available == true) {
      //   try {
       ///     wait();
            
      //   } catch (InterruptedException e) { } 
     // }
      
      //System.out.println("leave");
      //System.out.println("leave");
      available = true;
        try {
            sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(Intersection.class.getName()).log(Level.SEVERE, null, ex);
        }
      //System.out.println(available);
      notifyAll();
   }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
    public boolean getAvailable(){
        return available;
    }
    
    class DeadlockDetector extends Thread {
        @Override
        public void run(){
            while(true){
                
                
                try {
                    double start = System.currentTimeMillis();
                    double finish = System.currentTimeMillis();
                    
                    
                    
                    while(available == false){
                        if(finish-start>10000){
                            System.out.println("reset");
                            for(ClientThread c: clientThreadList){
                                if(c.getClient().getCurrentIntersection() == thisInter && c.getClient().getAtIntersection()){
                                    c.stop();
                                    c.getIcon().setVisible(false);
                                    c.getClient().resetPosition();
                                    leave();
                                    System.out.println("del");
                                    
                                }
                            }
                            for(SupplierThread s: supplierThreadList){
                                if(s.getSupplier().getCurrentIntersection() == thisInter && s.getSupplier().getAtIntersection()){
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

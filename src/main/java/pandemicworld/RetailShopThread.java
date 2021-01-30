package pandemicworld;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread that operates retail shop.
 *
 */
public class RetailShopThread extends Thread {

    private RetailShop shop;
    private ArrayList<Person> supplierList;
    private ArrayList<Person> clientList;
    private ControlPanel controlPanel;

    /**
     * Thread that operates retail shop.
     *
     */
    RetailShopThread(RetailShop shop, ArrayList<Person> supplierList, ArrayList<Person> clientList, ControlPanel controlPanel) {
        this.shop = shop;
        this.clientList = clientList;
        this.supplierList = supplierList;
        this.controlPanel = controlPanel;
    }

    public RetailShop getRetailShop() {
        return shop;
    }

    /**
     * Check if shops should be lockeddown.
     */
    @Override
    public void run() {
        while (true) {
            double infected = 0;
            double numOfPeople = 0;
            for (Person c : clientList) {
                if ((c.getPosition().getX() != 0 && c.getPosition().getY() != 0) || c.getInShop()) {
                    numOfPeople++;
                    if (c.getSick()) {
                        infected++;
                    }
                }
            }
            for (Person s : supplierList) {
                if ((s.getPosition().getX() != 0 && s.getPosition().getY() != 0) || s.getInShop()) {
                    numOfPeople++;
                    if (s.getSick()) {
                        infected++;
                    }
                }
            }
            if (infected / numOfPeople > controlPanel.getLockDownTreshold()) {
                shop.setLockdown(true);
            } else {
                shop.setLockdown(false);
            }

            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RetailShopThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

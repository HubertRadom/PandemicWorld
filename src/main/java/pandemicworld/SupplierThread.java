package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Thread that operates supplier.
 *
 */
public class SupplierThread extends Thread {

    private Supplier supplier;
    private ArrayList<ArrayList> adjacency;
    private ArrayList<RetailShop> retailShopList;
    private ArrayList<WholesaleStore> wholesaleStoreList;
    private ArrayList<Person> suppliersList;
    private HashMap<String, Street> roadMap;
    private HashMap<String, ImageIcon> images;
    private int from, to;
    private Street currentRoad;
    private boolean next = false;
    private JLabel icon;
    private int index = 1;
    private ControlPanel controlPanel;
    private int visitsToRecover;

    public SupplierThread(Supplier supplier, ArrayList<ArrayList> adjacency, HashMap<String, Street> roadMap, ArrayList<RetailShop> retailShopList,
            ArrayList<WholesaleStore> wholesaleStoreList, JLabel icon, HashMap<String, ImageIcon> images, ArrayList<Person> suppliersList,
            ControlPanel controlPanel) {
        this.supplier = supplier;
        this.adjacency = adjacency;
        this.roadMap = roadMap;
        this.from = supplier.getRoute().get(0);
        this.to = supplier.getRoute().get(1);
        this.retailShopList = retailShopList;
        this.icon = icon;
        this.images = images;
        this.wholesaleStoreList = wholesaleStoreList;
        this.suppliersList = suppliersList;
        this.controlPanel = controlPanel;
        this.visitsToRecover = controlPanel.getVisitsBeforeRecover();

    }

    public JLabel getIcon() {
        return icon;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * If the shop to which the supplier is going is in another area, first he
     * goes to the main intersection "x".
     */
    @Override
    public void run() {
        while (true) {
            if (visitsToRecover < 0 && supplier.getSick()) {
                visitsToRecover = controlPanel.getVisitsBeforeRecover();
                supplier.setSick(true);
            }

            if (visitsToRecover == 0 && supplier.getSick()) {
                supplier.setSick(false);
            }

            if (next == true) {

                currentRoad = roadMap.get("x " + Integer.toString(to));
                next = false;

            } else if (adjacency.get(from).get(to).equals(1)) {

                currentRoad = roadMap.get(Integer.toString(from) + " " + Integer.toString(to));

            } else {

                next = true;
                currentRoad = roadMap.get(Integer.toString(from) + " x");

            }

            supplier.travel(currentRoad, suppliersList, 32, supplier.getCar());

            //next shop
            if (next == false) {
                supplier.getCar().fillTank();
                visitsToRecover--;
                if (to >= 10) {
                    try {
                        supplier.getProducts(wholesaleStoreList.get(to - 10));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SupplierThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        if (supplier.getSick()) {
                            if (supplier.getMask()) {
                                supplier.infect(retailShopList.get(to), controlPanel.getTransRateMask(), controlPanel.getTransIfVacc());
                            } else {
                                supplier.infect(retailShopList.get(to), controlPanel.getTransRate(), controlPanel.getTransIfVacc());
                            }
                        }
                        supplier.giveProducts(retailShopList.get(to));
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SupplierThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (index >= supplier.getRoute().size() - 1) {
                    index = 0;
                } else {
                    index++;
                }
                from = to;
                to = supplier.getRoute().get(index);

            }

        }

    }
}

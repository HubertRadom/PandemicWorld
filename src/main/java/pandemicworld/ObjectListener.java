package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Allows to listen click event on JLabel, and transmits data to information
 * window.
 *
 */
class ObjectListener extends MouseAdapter {

    private ClientThread clientThread;
    private SupplierThread supplierThread;
    private RetailShopThread retailShopThread;
    private WholesaleStoreThread wholesaleStoreThread;
    private InformationWindow informationWindow;
    private String currentObject;

    ObjectListener(ClientThread clientThread, InformationWindow informationWindow) {
        this.clientThread = clientThread;
        this.informationWindow = informationWindow;
        this.currentObject = "client";
    }

    ObjectListener(SupplierThread supplierThread, InformationWindow informationWindow) {
        this.supplierThread = supplierThread;
        this.informationWindow = informationWindow;
        this.currentObject = "supplier";
    }

    ObjectListener(RetailShopThread retailShopThread, InformationWindow informationWindow) {
        this.retailShopThread = retailShopThread;
        this.informationWindow = informationWindow;
        this.currentObject = "retail";
    }

    ObjectListener(WholesaleStoreThread wholesaleStoreThread, InformationWindow informationWindow) {
        this.wholesaleStoreThread = wholesaleStoreThread;
        this.informationWindow = informationWindow;
        this.currentObject = "wholesale";
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (currentObject) {
            case "client":
                informationWindow.refreshClient(clientThread);
                break;
            case "supplier":
                informationWindow.refreshSupplier(supplierThread);
                break;
            case "retail":
                informationWindow.refreshRetailShop(retailShopThread);
                break;
            case "wholesale":
                informationWindow.refreshWholesaleStore(wholesaleStoreThread);
                break;
        }
    }

}

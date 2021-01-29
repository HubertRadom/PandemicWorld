
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class ObjectListener extends MouseAdapter {
    
    private ClientThread clientThread;
    private SupplierThread supplierThread;
    private RetailShopThread retailShopThread;
    private WholesaleStoreThread wholesaleStoreThread;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    private String currentObject;
    
    ObjectListener(ClientThread clientThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.clientThread = clientThread;
        this.informationWindow = informationWindow;
        this.images = images;  
        this.currentObject = "client";
    }
    ObjectListener(SupplierThread supplierThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.supplierThread = supplierThread;
        this.informationWindow = informationWindow;
        this.images = images;  
        this.currentObject = "supplier";
    }
    ObjectListener(RetailShopThread retailShopThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.retailShopThread = retailShopThread;
        this.informationWindow = informationWindow;
        this.images = images;  
        this.currentObject = "retail";
    }
    ObjectListener(WholesaleStoreThread wholesaleStoreThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.wholesaleStoreThread = wholesaleStoreThread;
        this.informationWindow = informationWindow;
        this.images = images;  
        this.currentObject = "wholesale";
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(currentObject){
            case "client":
                informationWindow.refreshClient(clientThread, images);
                break;
            case "supplier":
                informationWindow.refreshSupplier(supplierThread, images);
                break;
            case "retail":
                informationWindow.refreshRetailShop(retailShopThread, images);
                break;
            case "wholesale":
                informationWindow.refreshWholesaleStore(wholesaleStoreThread, images);
                break;
        }
    }

}
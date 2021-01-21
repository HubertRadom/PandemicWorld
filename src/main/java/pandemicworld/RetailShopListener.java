
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class RetailShopListener extends MouseAdapter {
    
    private RetailShopThread retailShopThread;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    
    RetailShopListener(RetailShopThread retailShopThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.retailShopThread = retailShopThread;
        this.informationWindow = informationWindow;   
        this.images = images;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        informationWindow.refreshRetailShop(retailShopThread, images);
        System.out.println("retailshop click");
    }

}
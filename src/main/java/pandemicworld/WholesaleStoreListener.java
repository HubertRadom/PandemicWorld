
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class WholesaleStoreListener extends MouseAdapter {
    
    private WholesaleStoreThread wholesaleStoreThread;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    
    
    WholesaleStoreListener(WholesaleStoreThread wholesaleStoreThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.wholesaleStoreThread = wholesaleStoreThread;
        this.informationWindow = informationWindow;
        this.images = images;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        informationWindow.refreshWholesaleStore(wholesaleStoreThread, images);
        System.out.println("wholesalestore click");
    }

}
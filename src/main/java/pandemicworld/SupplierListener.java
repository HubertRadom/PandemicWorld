
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class SupplierListener extends MouseAdapter {
    
    private SupplierThread supplierThread;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    
    SupplierListener(SupplierThread supplierThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.supplierThread = supplierThread;
        this.informationWindow = informationWindow;
        this.images = images;
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        informationWindow.refreshSupplier(supplierThread, images);
        System.out.println("supplier click");
    }

}
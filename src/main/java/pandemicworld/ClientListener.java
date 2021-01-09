
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class ClientListener extends MouseAdapter {
    
    private Client client;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    
    ClientListener(Client client, InformationWindow informationWindow,HashMap<String, ImageIcon>images){
        this.client = client;
        this.informationWindow = informationWindow;
        this.images = images;
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
        //System.out.println(informationWindow);
        informationWindow.refreshClient(client, images);
    }

}
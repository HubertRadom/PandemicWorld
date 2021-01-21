
package pandemicworld;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;

class ClientListener extends MouseAdapter {
    
    private ClientThread clientThread;
    private InformationWindow informationWindow;
    private HashMap<String, ImageIcon>images;
    
    ClientListener(ClientThread clientThread, InformationWindow informationWindow, HashMap<String, ImageIcon>images){
        this.clientThread = clientThread;
        this.informationWindow = informationWindow;
        this.images = images;
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        informationWindow.refreshClient(clientThread, images);
       // System.out.println(clientThread.getClient().getAtIntersection());
        //System.out.println(clientThread.getClient().getCurrentIntersection());
    }

}
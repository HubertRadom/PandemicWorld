package pandemicworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClientThread extends Thread {
    private Client client;
    private ArrayList<ArrayList>adjacency;
    private ArrayList<RetailShop>retailShopList;
    private ArrayList<Person>clientsList;
    private HashMap<String, Street>sidewalkMap;
    private HashMap<String, ImageIcon>images;
    private int from, to;
    private Street currentSidewalk;
    //private Street nextStreet;
    private boolean next = false;
    private JLabel icon;
    private ControlPanel controlPanel;
    private int visitsToRecover;

    public ClientThread(Client client, ArrayList<ArrayList>adjacency, HashMap<String, Street>sidewalkMap, int from, int to, ArrayList<RetailShop>retailShopList, 
            JLabel icon, HashMap<String, ImageIcon>images, ArrayList<Person>clientsList, ControlPanel controlPanel) {
        this.client = client;
        this.adjacency = adjacency;
        this.sidewalkMap = sidewalkMap;
        this.from = from;
        this.to = to;
        this.retailShopList = retailShopList;
        this.icon = icon;
        this.images = images;
        this.clientsList = clientsList;
        this.controlPanel = controlPanel;
        this.visitsToRecover = controlPanel.getVisitsBeforeRecover();
        
        
       // Paint paint = new Paint();
       // paint.start();   
    }

    public JLabel getIcon(){
        return icon;
    }
    
    public Client getClient(){
        return client;
    }
    

    @Override
    public void run() {
        
        while(true){
            if(visitsToRecover < 0 && client.getSick()){
                visitsToRecover = controlPanel.getVisitsBeforeRecover();
                client.setSick(true);
            }
            
            if(visitsToRecover == 0 && client.getSick()){
                client.setSick(false);
            } 
            
            
            if(next == true){

                currentSidewalk = sidewalkMap.get("x " + Integer.toString(to));
                next = false;

            } else if(adjacency.get(from).get(to).equals(1)){       

                currentSidewalk = sidewalkMap.get(Integer.toString(from)+ " " + Integer.toString(to));

            } else {

                next = true;
                currentSidewalk = sidewalkMap.get(Integer.toString(from)+ " x");

            } 


            client.travel(currentSidewalk, clientsList, 16);

            //next shop
            if(next==false){
                visitsToRecover--;
                //icon.setVisible(false);
               // client.resetPosition();
                
                try {
                    
                    if(client.getSick()){
                        if(client.getMask()){
                            client.infect(retailShopList.get(to), controlPanel.getTransRateMask(), controlPanel.getTransIfVacc());
                        } else{
                            client.infect(retailShopList.get(to), controlPanel.getTransRate(), controlPanel.getTransIfVacc());
                        }
                    }
                    
                client.buy(retailShopList.get(to),icon);
                client.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //client.getPosition().setX(retailShopList.get(to).getExit().getX());
                //client.getPosition().setY(retailShopList.get(to).getExit().getY());
                //System.out.println(to);
                //icon.setVisible(true);
                
                from = to;
                to = client.nextShop();
                
            }

        }

    }
/*
    class Paint extends Thread {
        @Override
        public void run() {
            while(true){
                icon.setBounds(client.getPosition().getX()-(32/2), client.getPosition().getY()-(32/2),32,32);
                
                if(client.getMask() == true){
                    if(client.getSick() == true){
                        icon.setIcon(images.get("sickMaskImage"));
                    } else{
                        icon.setIcon(images.get("healthyMaskImage"));
                    }
                } else {
                    if(client.getSick() == true){
                        icon.setIcon(images.get("sickImage"));
                    } else {
                        icon.setIcon(images.get("healthyImage"));
                    }
                }
                
                sleep(20);
            }
        }
    }
    */
}
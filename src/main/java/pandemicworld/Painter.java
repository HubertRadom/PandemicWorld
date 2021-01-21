package pandemicworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Painter extends Thread{
    private HashMap<String, ImageIcon>images;
    private ArrayList<ClientThread>clientThreadList;
    private ArrayList<SupplierThread>supplierThreadList;
    //private ArrayList<ClientThread>clientThreadList;
    Painter(HashMap<String, ImageIcon>images, ArrayList<ClientThread>clientThreadList, ArrayList<SupplierThread>supplierThreadList){
        this.images = images;
        this.clientThreadList = clientThreadList;
        this.supplierThreadList = supplierThreadList;        
    }
    
    @Override
    public void run(){
        while(true){
            for(ClientThread c: clientThreadList){
                c.getIcon().setBounds(c.getClient().getPosition().getX()-(32/2), c.getClient().getPosition().getY()-(32/2),32,32);
                
                if(c.getClient().getMask() == true){
                    if(c.getClient().getSick() == true){
                        c.getIcon().setIcon(images.get("sickMaskImage"));
                    } else{
                        c.getIcon().setIcon(images.get("healthyMaskImage"));
                    }
                } else {
                    if(c.getClient().getSick() == true){
                        c.getIcon().setIcon(images.get("sickImage"));
                    } else {
                        c.getIcon().setIcon(images.get("healthyImage"));
                    }
                }
            }
            for(SupplierThread s: supplierThreadList){
                if (s.getSupplier().getDirection() == "up"){
                    s.getIcon().setBounds(s.getSupplier().getPosition().getX()-(32/2), s.getSupplier().getPosition().getY()-(64/2),32,64);
                    if (s.getSupplier().getCar().getBrand() == "ferrari"){
                        s.getIcon().setIcon(images.get("ferrariUpImage"));
                    } else if (s.getSupplier().getCar().getBrand() == "golf"){
                        s.getIcon().setIcon(images.get("golfUpImage"));
                    } else {
                        s.getIcon().setIcon(images.get("carUpImage"));
                    }   
                } else if (s.getSupplier().getDirection() == "down"){
                    s.getIcon().setBounds(s.getSupplier().getPosition().getX()-(32/2), s.getSupplier().getPosition().getY()-(64/2),32,64);
                    if (s.getSupplier().getCar().getBrand() == "ferrari"){
                        s.getIcon().setIcon(images.get("ferrariDownImage"));
                    } else if (s.getSupplier().getCar().getBrand() == "golf"){
                        s.getIcon().setIcon(images.get("golfDownImage"));
                    } else {
                        s.getIcon().setIcon(images.get("carDownImage"));
                    }    
                } else if (s.getSupplier().getDirection() == "right"){
                    s.getIcon().setBounds(s.getSupplier().getPosition().getX()-(64/2), s.getSupplier().getPosition().getY()-(32/2),64,32);
                    if (s.getSupplier().getCar().getBrand() == "ferrari"){
                        s.getIcon().setIcon(images.get("ferrariRightImage"));
                    } else if (s.getSupplier().getCar().getBrand() == "golf"){
                        s.getIcon().setIcon(images.get("golfRightImage"));
                    } else {
                        s.getIcon().setIcon(images.get("carRightImage"));
                    }      
                } else if (s.getSupplier().getDirection() == "left"){
                    s.getIcon().setBounds(s.getSupplier().getPosition().getX()-(64/2), s.getSupplier().getPosition().getY()-(32/2),64,32);
                    if (s.getSupplier().getCar().getBrand() == "ferrari"){
                        s.getIcon().setIcon(images.get("ferrariLeftImage"));
                    } else if (s.getSupplier().getCar().getBrand() == "golf"){
                        s.getIcon().setIcon(images.get("golfLeftImage"));
                    } else {
                        s.getIcon().setIcon(images.get("carLeftImage"));
                    }     
                }
            }
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

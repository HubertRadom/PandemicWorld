package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SupplierThread extends Thread {
    private Supplier supplier;
    private ArrayList<ArrayList>adjacency;
    private ArrayList<RetailShop>retailShopList;
    private ArrayList<WholesaleStore>wholesaleStoreList;
    private ArrayList<Person>suppliersList;
    private HashMap<String, Street>roadMap;
    private HashMap<String, ImageIcon>images;
    private int from, to;
    private Street currentRoad;
    private boolean next = false;
    private JLabel icon;
    private int index = 1;
    

    public SupplierThread(Supplier supplier, ArrayList<ArrayList>adjacency, HashMap<String, Street>roadMap, ArrayList<RetailShop>retailShopList, 
             ArrayList<WholesaleStore>wholesaleStoreList, JLabel icon, HashMap<String, ImageIcon>images, ArrayList<Person>suppliersList) {
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
        

        //Paint paint = new Paint();
        //paint.start();   
    }

    public JLabel getIcon(){
        return icon;
    }
    
    public Supplier getSupplier(){
        return supplier;
    }
    

    @Override
    public void run() {
        while(true){

            if(next == true){

                currentRoad = roadMap.get("x " + Integer.toString(to));
                next = false;

            } else if(adjacency.get(from).get(to).equals(1)){       

                currentRoad = roadMap.get(Integer.toString(from)+ " " + Integer.toString(to));

            } else {

                next = true;
                currentRoad = roadMap.get(Integer.toString(from)+ " x");

            } 

            supplier.travel(currentRoad, suppliersList, 32);

            //next shop
            if(next==false){
                if(to >= 10){
                    try {
                        supplier.getProducts(wholesaleStoreList.get(to-10));
                        //System.out.println(supplier.getTrunk());
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SupplierThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        //retailShopList.get(to).getPeople().add(this);
                        supplier.giveProducts(retailShopList.get(to));
                        //retailShopList.get(to).getPeople().remove(this);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SupplierThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                if(index >= supplier.getRoute().size()-1){
                    index = 0;
                } else {
                    index++;
                }
                //System.out.println(index);
                from = to;
                to = supplier.getRoute().get(index);

            }

        }

    }
/*
    class Paint extends Thread {
        @Override
        public void run() {
            while(true){
                //icon.setBounds(supplier.getPosition().getX()-(32/2), supplier.getPosition().getY()-(32/2),32,32);
                
            if (supplier.getDirection() == "up"){
                icon.setBounds(supplier.getPosition().getX()-(32/2), supplier.getPosition().getY()-(64/2),32,64);
                if (supplier.getCar().getBrand() == "ferrari"){
                    icon.setIcon(images.get("ferrariUpImage"));
                } else if (supplier.getCar().getBrand() == "golf"){
                    icon.setIcon(images.get("golfUpImage"));
                } else {
                    icon.setIcon(images.get("carUpImage"));
                }   
            } else if (supplier.getDirection() == "down"){
                icon.setBounds(supplier.getPosition().getX()-(32/2), supplier.getPosition().getY()-(64/2),32,64);
                if (supplier.getCar().getBrand() == "ferrari"){
                    icon.setIcon(images.get("ferrariDownImage"));
                } else if (supplier.getCar().getBrand() == "golf"){
                    icon.setIcon(images.get("golfDownImage"));
                } else {
                    icon.setIcon(images.get("carDownImage"));
                }    
            } else if (supplier.getDirection() == "right"){
                icon.setBounds(supplier.getPosition().getX()-(64/2), supplier.getPosition().getY()-(32/2),64,32);
                if (supplier.getCar().getBrand() == "ferrari"){
                    icon.setIcon(images.get("ferrariRightImage"));
                } else if (supplier.getCar().getBrand() == "golf"){
                    icon.setIcon(images.get("golfRightImage"));
                } else {
                    icon.setIcon(images.get("carRightImage"));
                }      
            } else if (supplier.getDirection() == "left"){
                icon.setBounds(supplier.getPosition().getX()-(64/2), supplier.getPosition().getY()-(32/2),64,32);
                if (supplier.getCar().getBrand() == "ferrari"){
                    icon.setIcon(images.get("ferrariLeftImage"));
                } else if (supplier.getCar().getBrand() == "golf"){
                    icon.setIcon(images.get("golfLeftImage"));
                } else {
                    icon.setIcon(images.get("carLeftImage"));
                }     
            }
                
                sleep(20);
            }
        }
    }
    */
}
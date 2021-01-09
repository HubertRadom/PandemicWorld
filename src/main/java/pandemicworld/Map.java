
package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Map extends JPanel {

    private ArrayList<Client> clientList;
    private ArrayList<Supplier> supplierList;
    private ArrayList<ClientThread> clientThreadList;
    private ArrayList<RetailShop> retailShopList;
    private ArrayList<ArrayList> adjacency;
    
    //ImageIcon icon = new ImageIcon("images/sick.png");
    
    private Image backgroundImage = ImageIO.read(new File("images/mapanew.png"));
    private ImageIcon backgroundImage2 = new ImageIcon("images/mapanew.png");
    private ImageIcon healthyImage = new ImageIcon("images/healthy.png");
    private ImageIcon healthyMaskImage = new ImageIcon("images/healthymask.png");
    private ImageIcon sickImage = new ImageIcon("images/sick.png");
    private ImageIcon sickMaskImage = new ImageIcon("images/sickmask.png");
    
    private ImageIcon ferrariDownImage = new ImageIcon("images/ferraridown.png");
    private ImageIcon ferrariUpImage = new ImageIcon("images/ferrariup.png");
    private ImageIcon ferrariLeftImage = new ImageIcon("images/ferrarileft.png");
    private ImageIcon ferrariRightImage = new ImageIcon("images/ferrariright.png");
    
    private ImageIcon golfDownImage = new ImageIcon("images/golfdown.png");
    private ImageIcon golfUpImage = new ImageIcon("images/golfup.png");
    private ImageIcon golfLeftImage = new ImageIcon("images/golfleft.png");
    private ImageIcon golfRightImage = new ImageIcon("images/golfright.png");
    
    private ImageIcon carDownImage = new ImageIcon("images/cardown.png");
    private ImageIcon carUpImage = new ImageIcon("images/carup.png");
    private ImageIcon carLeftImage = new ImageIcon("images/carleft.png");
    private ImageIcon carRightImage = new ImageIcon("images/carright.png");
    

    private HashMap<String, Street> sidewalkMap;
    private HashMap<String, Street> roadMap;
    private HashMap<String, ImageIcon> images;



    public Map(InformationWindow informationWindow) throws IOException {
        clientList = new ArrayList<>();
        supplierList = new ArrayList<>();
        retailShopList = new ArrayList<>();
        adjacency = new ArrayList<>();
        //sidewalkList = new ArrayList<>();
        sidewalkMap = new HashMap<String, Street>();
        roadMap = new HashMap<String, Street>();
        clientThreadList = new ArrayList<>();
        images = new HashMap<String, ImageIcon>();

        images.put("healthyImage",healthyImage);
        images.put("healthyMaskImage",healthyMaskImage);
        images.put("sickImage",sickImage);
        images.put("sickMaskImage",sickMaskImage);
        images.put("ferrariDownImage",ferrariDownImage);
        images.put("ferrariUpImage",ferrariUpImage);
        images.put("ferrariLeftImage",ferrariLeftImage);
        images.put("ferrariRightImage",ferrariRightImage);
        images.put("golfDownImage",golfDownImage);
        images.put("golfUpImage",golfUpImage);
        images.put("golfLeftImage",golfLeftImage);
        images.put("golfRightImage",golfRightImage); 
        images.put("carDownImage",carDownImage);
        images.put("carUpImage",carUpImage);
        images.put("carLeftImage",carLeftImage);
        images.put("carRightImage",carRightImage);
        
        
        setFocusable(true);
        


        RetailShop shop0 = new RetailShop(new Position(700,200),"d","c",1,2);
        RetailShop shop1 = new RetailShop(new Position(330,100),"d","c",1,2);  
        RetailShop shop2 = new RetailShop(new Position(100,300),"d","c",1,2);
        RetailShop shop3 = new RetailShop(new Position(330,500),"d","c",1,2);
        RetailShop shop4 = new RetailShop(new Position(100,500),"d","c",1,2);
        RetailShop shop5 = new RetailShop(new Position(700,200),"d","c",1,2);
        RetailShop shop6 = new RetailShop(new Position(330,100),"d","c",1,2);  
        RetailShop shop7 = new RetailShop(new Position(100,300),"d","c",1,2);
        RetailShop shop8 = new RetailShop(new Position(330,500),"d","c",1,2);
        RetailShop shop9 = new RetailShop(new Position(100,500),"d","c",1,2);
        retailShopList.add(shop0);
        retailShopList.add(shop1);
        retailShopList.add(shop2);
        retailShopList.add(shop3);
        retailShopList.add(shop4);
        retailShopList.add(shop5);
        retailShopList.add(shop6);
        retailShopList.add(shop7);
        retailShopList.add(shop8);
        retailShopList.add(shop9);
        
        Product prod1 = new Product(1, "a", "b", "2000.01.01");
        Product prod2 = new Product(1, "a", "b", "2000.01.01");
        Product prod3 = new Product(1, "a", "b", "2000.01.01");
        Product prod4 = new Product(1, "a", "b", "2000.01.01");
        Product prod5 = new Product(1, "a", "b", "2000.01.01");
        shop1.addProduct(prod1);
        shop1.addProduct(prod2);
        shop1.addProduct(prod3);
        shop1.addProduct(prod4);
        
        Intersection intersection1 = new Intersection(new Position(330,300));       

        //x = main intersection
        //SIDEWALK
        //AREA1
        sidewalkMap.put("0 x", new Street("0 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,140), new Position(18,384), new Position(680,384)))));
        sidewalkMap.put("x 0", new Street("x 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(18,384), new Position(18,140)))));
        
        sidewalkMap.put("1 x", new Street("1 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,384), new Position(680,384)))));
        sidewalkMap.put("x 1", new Street("x 1", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(18,384), new Position(18,657)))));
        
        sidewalkMap.put("2 x", new Street("2 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(304,325), new Position(304,384), new Position(680,384)))));
        sidewalkMap.put("x 2", new Street("x 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(304,384), new Position(304,325)))));
        
        sidewalkMap.put("0 1", new Street("0 1", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,140), new Position(18,657)))));
        sidewalkMap.put("1 0", new Street("1 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,140)))));
        
        sidewalkMap.put("0 2", new Street("0 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,140), new Position(18,384), new Position(304,384), new Position(304,325)))));
        sidewalkMap.put("2 0", new Street("2 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(304,325), new Position(304,384), new Position(18,384), new Position(18,140)))));
        
        sidewalkMap.put("1 2", new Street("0 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,384), new Position(304,384), new Position(304,325)))));
        sidewalkMap.put("2 1", new Street("2 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(304,325), new Position(304,384), new Position(18,384), new Position(18,657)))));
        
        //AREA2
        sidewalkMap.put("3 x", new Street("3 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(538,573), new Position(680,573), new Position(680,384)))));
        sidewalkMap.put("x 3", new Street("x 3", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,573), new Position(538,573)))));
        
        sidewalkMap.put("4 x", new Street("4 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,700), new Position(680,384)))));
        sidewalkMap.put("x 4", new Street("x 4", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,700)))));
        
        sidewalkMap.put("3 4", new Street("3 4", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(538,573), new Position(680,573), new Position(680,700)))));
        sidewalkMap.put("4 3", new Street("4 3", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,700), new Position(680,573), new Position(538,573)))));
        
        //AREA3
        sidewalkMap.put("5 x", new Street("5 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(610,270), new Position(680,270), new Position(680,384)))));
        sidewalkMap.put("x 5", new Street("x 5", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,270), new Position(610,270)))));
        
        sidewalkMap.put("6 x", new Street("6 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1020,165), new Position(680,165), new Position(680,384)))));
        sidewalkMap.put("x 6", new Street("x 6", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,165), new Position(1020,165)))));
        
        sidewalkMap.put("5 6", new Street("5 6", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(610,270), new Position(680,270), new Position(680,165), new Position(1020,165)))));
        sidewalkMap.put("6 5", new Street("6 5", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1020,165), new Position(680,165), new Position(680,270), new Position(610,270)))));
        
        //AREA4
        sidewalkMap.put("7 x", new Street("7 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1297,165), new Position(1297,384), new Position(680,384)))));
        sidewalkMap.put("x 7", new Street("x 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(1297,384), new Position(1297,165)))));
        
        sidewalkMap.put("8 x", new Street("8 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1297,280), new Position(1297,384), new Position(680,384)))));
        sidewalkMap.put("x 8", new Street("x 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(1297,384), new Position(1297,280), new Position(1463,280)))));
        
        sidewalkMap.put("9 x", new Street("9 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,384), new Position(680,384)))));
        sidewalkMap.put("x 9", new Street("x 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(1297,384), new Position(1297,669), new Position(1480,669)))));
        
        sidewalkMap.put("7 8", new Street("7 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1297,165), new Position(1297,280), new Position(1463,280)))));
        sidewalkMap.put("8 7", new Street("8 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1297,280), new Position(1297,165)))));
        
        sidewalkMap.put("7 9", new Street("7 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1297,165), new Position(1297,669), new Position(1480,669)))));
        sidewalkMap.put("9 7", new Street("9 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,165)))));
        
        sidewalkMap.put("8 9", new Street("8 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1297,280), new Position(1297,669), new Position(1480,669)))));
        sidewalkMap.put("9 8", new Street("9 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,280), new Position(1463,280)))));
        
        
        //ROAD
        //AREA1
        roadMap.put("0 x", new Street("0 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,450), new Position(712,450)))));
        roadMap.put("x 0", new Street("x 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,419), new Position(94,419), new Position(94,178)))));
        
        roadMap.put("1 x", new Street("1 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,450), new Position(712,450)))));
        roadMap.put("x 1", new Street("x 1", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,419), new Position(62,419), new Position(62,637)))));
        
        roadMap.put("2 x", new Street("2 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,450), new Position(712,450)))));
        roadMap.put("x 2", new Street("x 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,419), new Position(379,419), new Position(379,330)))));
        
        roadMap.put("0 1", new Street("0 1", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,637)))));
        roadMap.put("1 0", new Street("1 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,178)))));
        
        roadMap.put("0 2", new Street("0 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,450), new Position(379,450), new Position(379,330)))));
        roadMap.put("2 0", new Street("2 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,419), new Position(94,419), new Position(94,178)))));
        
        roadMap.put("1 2", new Street("0 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,450), new Position(379,450), new Position(379,330)))));
        roadMap.put("2 1", new Street("2 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,419), new Position(62,419), new Position(62,637)))));
        
        //AREA2
        roadMap.put("3 x", new Street("3 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(550,642), new Position(744,642), new Position(744,450)))));
        roadMap.put("x 3", new Street("x 3", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,450), new Position(712,610), new Position(550,610)))));
        
        roadMap.put("4 x", new Street("4 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,680), new Position(744,450)))));
        roadMap.put("x 4", new Street("x 4", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,450), new Position(712,680)))));
        
        roadMap.put("3 4", new Street("3 4", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(550,642), new Position(712,642), new Position(712,680)))));
        roadMap.put("4 3", new Street("4 3", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,680), new Position(744,610), new Position(550,610)))));
        
        //AREA3
        roadMap.put("5 x", new Street("5 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(620,233), new Position(712,233), new Position(712,419)))));
        roadMap.put("x 5", new Street("x 5", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,419), new Position(744,201), new Position(620,201)))));
        
        roadMap.put("6 x", new Street("6 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1010,201), new Position(712,201), new Position(712,419)))));
        roadMap.put("x 6", new Street("x 6", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,419), new Position(744,233), new Position(1010,233)))));
        
        roadMap.put("5 6", new Street("5 6", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(620,233), new Position(1010,233)))));
        roadMap.put("6 5", new Street("6 5", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1010,201), new Position(620,201)))));
        
        //AREA4
        roadMap.put("7 x", new Street("7 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,419), new Position(744,419)))));
        roadMap.put("x 7", new Street("x 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1366,450), new Position(1366,159)))));
        
        roadMap.put("8 x", new Street("8 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1333,210), new Position(1333,419), new Position(744,419)))));
        roadMap.put("x 8", new Street("x 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1366,450), new Position(1366,242), new Position(1458,242)))));
        
        roadMap.put("9 x", new Street("9 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,419), new Position(744,419)))));
        roadMap.put("x 9", new Street("x 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1333,450), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        
        roadMap.put("7 8", new Street("7 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,242), new Position(1458,242)))));
        roadMap.put("8 7", new Street("8 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1366,210), new Position(1366,159)))));
        
        roadMap.put("7 9", new Street("7 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        roadMap.put("9 7", new Street("9 7", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,159)))));
        
        roadMap.put("8 9", new Street("8 9", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1333,210), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        roadMap.put("9 8", new Street("9 8", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,242), new Position(1458,242)))));

        
        //0
        adjacency.add(new ArrayList(Arrays.asList(0,1,1,0,0,0,0,0,0,0,1,0,0)));
        //1
        adjacency.add(new ArrayList(Arrays.asList(1,0,1,0,0,0,0,0,0,0,1,0,0)));
        //2
        adjacency.add(new ArrayList(Arrays.asList(1,1,0,0,0,0,0,0,0,0,1,0,0)));
        //3
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,1,0,0,0,0,0,0,1,0)));
        //4
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,1,0,0,0,0,0,0,0,1,0)));
        //5
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,0,1,0,0,0,0,0,1)));
        //6
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,1,0,0,0,0,0,0,1)));
        //7
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,0,0,0,1,1,0,0,0)));
        //8
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,0,0,1,0,1,0,0,0)));
        //9
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,0,0,1,1,0,0,0,0)));
        //10
        adjacency.add(new ArrayList(Arrays.asList(1,1,1,0,0,0,0,0,0,0,0,0,0)));
        //11
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,1,1,0,0,0,0,0,0,0,0)));
        //12
        adjacency.add(new ArrayList(Arrays.asList(0,0,0,0,0,1,1,0,0,0,0,0,0)));

/*
        for(int i = 0; i<60; i++){
            Client client1 = new Client(false,false,false,new Position(18,140),"a","a","a",1);
            clientList.add(client1);
            ClientThread c1 = new ClientThread(client1,adjacency,sidewalkMap,0,1);
            c1.start();
        } 
       */ 
        Supplier supplier1 = new Supplier(false,false,false,new Position(18,140),1,"a", new Car("foerrari",1,1,1), 2);
        supplierList.add(supplier1);
        SupplierThread s1 = new SupplierThread(supplier1,adjacency,roadMap,0,1);
        s1.start();
        
        Supplier supplier2 = new Supplier(false,false,false,new Position(18,140),1,"a", new Car("golf",1,1,1), 2);
        supplierList.add(supplier2);
        SupplierThread s2 = new SupplierThread(supplier2,adjacency,roadMap,0,6);
        s2.start();
        
        Supplier supplier3 = new Supplier(false,false,false,new Position(18,140),1,"a", new Car("dsfgf",1,1,1), 2);
        supplierList.add(supplier3);
        SupplierThread s3 = new SupplierThread(supplier3,adjacency,roadMap,0,1);
        s3.start();
        
        /*
        Client client1 = new Client(false,false,false,new Position(18,140),"a","a","a",1);
        clientList.add(client1);
        ClientThread c1 = new ClientThread(client1,adjacency,sidewalkMap,0,6);
        c1.start();
        
        Client client2 = new Client(false,false,false,new Position(1480,669),"a","a","a",1);
        clientList.add(client2);
        ClientThread c2 = new ClientThread(client2,adjacency,sidewalkMap,9,3);
        c2.start();
        */
        //Paint paint = new Paint();
        //paint.start();   
        
        JLabel background = new JLabel(backgroundImage2);
        background.setBounds(0, 0, 1600, 800);
        this.add(background);
        //System.out.println(informationWindow);
        
        JLabel jlabeltest = new JLabel(sickImage);
        jlabeltest.setBounds(18-16, 140-16, 32, 32);
    
        Client client1 = new Client(false,true,false,new Position(18,140),"a","a","a",1);
        ClientListener objectListener = new ClientListener(client1, informationWindow, images);
        jlabeltest.addMouseListener(objectListener);
        background.add(jlabeltest);
        
        ClientThread c1 = new ClientThread(client1,adjacency,sidewalkMap,0,1, retailShopList, jlabeltest, images);
        c1.start();
        
              
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.println("paint background");
        //g.drawImage(backgroundImage, 0, 0, this);

    /*        
        for(Client c: clientList){
            if(c.getMask() == true){
                if(c.getSick() == true){
                    g.drawImage(sickMaskImage, c.getPosition().getX()-(32/2), c.getPosition().getY()-(32/2), this);
                } else{
                    g.drawImage(healthyMaskImage, c.getPosition().getX()-(32/2), c.getPosition().getY()-(32/2), this);
                }
            } else {
                if(c.getSick() == true){
                    g.drawImage(sickImage, c.getPosition().getX()-(32/2), c.getPosition().getY()-(32/2), this);
                } else {
                    g.drawImage(healthyImage, c.getPosition().getX()-(32/2), c.getPosition().getY()-(32/2), this);
                }
            }
        }
        
        for(Supplier s: supplierList){
            
            if (s.getDirection() == "up"){
                if (s.getCar().getBrand() == "ferrari"){
                    g.drawImage(ferrariUpImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                } else if (s.getCar().getBrand() == "golf"){
                    g.drawImage(golfUpImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                } else {
                    g.drawImage(carUpImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                }   
            } else if (s.getDirection() == "down"){
                if (s.getCar().getBrand() == "ferrari"){
                    g.drawImage(ferrariDownImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                } else if (s.getCar().getBrand() == "golf"){
                    g.drawImage(golfDownImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                } else {
                    g.drawImage(carDownImage, s.getPosition().getX()-(32/2), s.getPosition().getY()-(64/2), this);
                }    
            } else if (s.getDirection() == "right"){
                if (s.getCar().getBrand() == "ferrari"){
                    g.drawImage(ferrariRightImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                } else if (s.getCar().getBrand() == "golf"){
                    g.drawImage(golfRightImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                } else {
                    g.drawImage(carRightImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                }      
            } else if (s.getDirection() == "left"){
                if (s.getCar().getBrand() == "ferrari"){
                    g.drawImage(ferrariLeftImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                } else if (s.getCar().getBrand() == "golf"){
                    g.drawImage(golfLeftImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                } else {
                    g.drawImage(carLeftImage, s.getPosition().getX()-(64/2), s.getPosition().getY()-(32/2), this);
                }     
            }
*/
        }
        /*
         g.setColor(new Color(255,255,255));
        for(RetailShop c: retailShopList){
            g.fillOval(c.getPosition().getX()-(25/2), c.getPosition().getY()-(25/2), 25, 25);
        } */
        
        /*
    } */
    /*
    public class Paint extends Thread {
        @Override
        public void run(){
            while(true){
                for(ClientThread c: clientThreadList){
                    
                    c.getIcon().setIcon(sickImage);
                }
                
                sleep(20);
               
            }
        }
    }
 */
    
    
    public class SupplierThread extends Thread {
        private Supplier supplier;
        private  ArrayList<ArrayList>adjacency;
        private  HashMap<String, Street>roadkMap;
        private int from, to;
        private Street currentRoad;
        //private Street nextStreet;
        private boolean next = false;
        
        
        public SupplierThread(Supplier s, ArrayList<ArrayList>a, HashMap<String, Street>r, int start, int end) {
            supplier = s;
            adjacency = a;
            roadMap = r;
            from = start;
            to = end;
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
                

                supplier.travel(currentRoad);
                
                
                //next shop
                if(next==false){

                    //supplier.buy(retailShopList.get(to),2);
                    //from = to;
                    //to = supplier.nextShop();

                }
                
            }
                     
        }
    }
    
    
    
}




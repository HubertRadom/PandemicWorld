
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

    private ArrayList<Person> clientList;
    private ArrayList<Person> supplierList;
    private ArrayList<ClientThread> clientThreadList;
    private ArrayList<SupplierThread> supplierThreadList;
    private ArrayList<RetailShop> retailShopList;
    private ArrayList<WholesaleStore> wholesaleStoreList; 
    private ArrayList<ArrayList> adjacency;
    private ArrayList<Intersection>area1;
    private ArrayList<Intersection>area2;
    private ArrayList<Intersection>area3;
    private ArrayList<Intersection>area4;
    
    private ImageIcon backgroundImage = new ImageIcon("images/mapanew.png");
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
    
    private ImageIcon retailShopImage = new ImageIcon("images/retailshop.png");
    private ImageIcon wholesaleStoreImage = new ImageIcon("images/wholesalestore.png");
    

    private HashMap<String, Street> sidewalkMap;
    private HashMap<String, Street> roadMap;
    private HashMap<String, ImageIcon> images;
    private JLabel background;



    public Map(InformationWindow informationWindow, ControlPanel controlPanel,  ArrayList<Person> clientList,
             ArrayList<Person> supplierList,  ArrayList<ClientThread>clientThreadList,
             ArrayList<SupplierThread> supplierThreadList, ArrayList<RetailShop> retailShopList,
             ArrayList<WholesaleStore> wholesaleStoreList, ArrayList<ArrayList> adjacency,
             HashMap<String, Street> sidewalkMap, HashMap<String, Street> roadMap, HashMap<String, 
                     ImageIcon> images, JLabel background) throws IOException {
        //clientList = new ArrayList<>();
        this.clientList = clientList;
        //supplierList = new ArrayList<>();
        this.supplierList = supplierList;
        //retailShopList = new ArrayList<>();
        this.retailShopList = retailShopList;
        //wholesaleStoreList = new ArrayList<>();
        this.wholesaleStoreList = wholesaleStoreList;
        //adjacency = new ArrayList<>();
        this.adjacency = adjacency;
        
        //sidewalkMap = new HashMap<String, Street>();
        this.sidewalkMap = sidewalkMap;
        //roadMap = new HashMap<String, Street>();
        this.roadMap = roadMap;
        //clientThreadList = new ArrayList<>();
        this.clientThreadList = clientThreadList;
        //supplierThreadList = new ArrayList<>();
        this.supplierThreadList = supplierThreadList;
        area1 = new ArrayList<>();
        area2 = new ArrayList<>();
        area3 = new ArrayList<>();
        area4 = new ArrayList<>();
        //images = new HashMap<String, ImageIcon>();
        this.images = images;

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
        images.put("retailShopImage",retailShopImage);
        images.put("wholesaleStoreImage",wholesaleStoreImage);
        
        
        setFocusable(true);
        this.background = background;
        background.setIcon(backgroundImage);
        background.setBounds(0, 0, 1600, 800);
        this.add(background);
        
        RetailShop shop0 = new RetailShop(new Position(132,140),"Dino","area 1, nr 0",100,20);
        RetailShopThread sh0 = new RetailShopThread(shop0, supplierList, clientList,controlPanel);
        ObjectListener shop0listener = new ObjectListener(sh0, informationWindow, images);
        JLabel shop0label = new JLabel();
        shop0label.setBounds(0, 0, 155, 135);
        shop0label.addMouseListener(shop0listener);
        background.add(shop0label);
        sh0.start();
        
        RetailShop shop1 = new RetailShop(new Position(18,657),"Lidl","area 1, nr 1",100,20);  
        RetailShopThread sh1 = new RetailShopThread(shop1, supplierList, clientList,controlPanel);
        ObjectListener shop1listener = new ObjectListener(sh1, informationWindow, images);
        JLabel shop1label = new JLabel();
        shop1label.setBounds(0, 666, 145, 130);
        shop1label.addMouseListener(shop1listener);
        background.add(shop1label);
        sh1.start();
        
        RetailShop shop2 = new RetailShop(new Position(415,325),"Tesco","area 1, nr 2",100,20);
        RetailShopThread sh2 = new RetailShopThread(shop2, supplierList, clientList,controlPanel);
        ObjectListener shop2listener = new ObjectListener(sh2, informationWindow, images);
        JLabel shop2label = new JLabel();
        shop2label.setBounds(240, 200, 180, 120);
        shop2label.addMouseListener(shop2listener);
        background.add(shop2label);
        sh2.start();
        
        RetailShop shop3 = new RetailShop(new Position(538,573),"Polo","area 2, nr 3",100,20);
        RetailShopThread sh3 = new RetailShopThread(shop3, supplierList, clientList,controlPanel);
        ObjectListener shop3listener = new ObjectListener(sh3, informationWindow, images);
        JLabel shop3label = new JLabel();
        shop3label.setBounds(417, 559, 115, 113);
        shop3label.addMouseListener(shop3listener);
        background.add(shop3label);
        sh3.start();
        
        RetailShop shop4 = new RetailShop(new Position(680,700),"Biedronka","area 2, nr 4",100,20);
        RetailShopThread sh4 = new RetailShopThread(shop4, supplierList, clientList,controlPanel);
        ObjectListener shop4listener = new ObjectListener(sh4, informationWindow, images);
        JLabel shop4label = new JLabel();
        shop4label.setBounds(665, 700, 105, 100);
        shop4label.addMouseListener(shop4listener);
        background.add(shop4label);
        sh4.start();
        
        RetailShop shop5 = new RetailShop(new Position(645,165),"Carrefour","area 3, nr 5",100,20);
        RetailShopThread sh5 = new RetailShopThread(shop5, supplierList, clientList,controlPanel);
        ObjectListener shop5listener = new ObjectListener(sh5, informationWindow, images);
        JLabel shop5label = new JLabel();
        shop5label.setBounds(500, 110, 105, 190);
        shop5label.addMouseListener(shop5listener);
        background.add(shop5label);
        sh5.start();
            
        RetailShop shop6 = new RetailShop(new Position(1020,270),"Monopolex","area 3, nr 6",100,20);
        RetailShopThread sh6 = new RetailShopThread(shop6, supplierList, clientList,controlPanel);
        ObjectListener shop6listener = new ObjectListener(sh6, informationWindow, images);
        JLabel shop6label = new JLabel();
        shop6label.setBounds(1024, 156, 112, 148);
        shop6label.addMouseListener(shop6listener);
        background.add(shop6label);
        sh6.start();
        
        RetailShop shop7 = new RetailShop(new Position(1407,165),"Żabka","area 4, nr 7",100,20);
        RetailShopThread sh7 = new RetailShopThread(shop7, supplierList, clientList,controlPanel);
        ObjectListener shop7listener = new ObjectListener(sh7, informationWindow, images);
        JLabel shop7label = new JLabel();
        shop7label.setBounds(1266, 0, 170, 155);
        shop7label.addMouseListener(shop7listener);
        background.add(shop7label);
        sh7.start();
        
        RetailShop shop8 = new RetailShop(new Position(1463,280),"Społem","area 4, nr 8",100,20);
        RetailShopThread sh8 = new RetailShopThread(shop8, supplierList, clientList,controlPanel);
        ObjectListener shop8listener = new ObjectListener(sh8, informationWindow, images);
        JLabel shop8label = new JLabel();
        shop8label.setBounds(1462, 163, 138, 145);
        shop8label.addMouseListener(shop8listener);
        background.add(shop8label);
        sh8.start();
        
        RetailShop shop9 = new RetailShop(new Position(1480,669),"Delikatesy","area 4, nr 9",100,20);
        RetailShopThread sh9 = new RetailShopThread(shop9, supplierList, clientList,controlPanel);
        ObjectListener shop9listener = new ObjectListener(sh9, informationWindow, images);
        JLabel shop9label = new JLabel();
        shop9label.setBounds(1443, 681, 157, 90);
        shop9label.addMouseListener(shop9listener);
        background.add(shop9label);
        sh9.start();
        
        
        WholesaleStore shop10 = new WholesaleStore(new Position(100,500),"Januszexpol","area 1, nr 10",10); 
        WholesaleStoreThread sh10 = new WholesaleStoreThread(shop10);
        ObjectListener shop10listener = new ObjectListener(sh10, informationWindow, images);
        JLabel shop10label = new JLabel();
        shop10label.setBounds(200, 685, 170, 100);
        shop10label.addMouseListener(shop10listener);
        background.add(shop10label);
        sh10.start();
        
        WholesaleStore shop11 = new WholesaleStore(new Position(100,500),"Hurtmex","area 2, nr 11",400);
        WholesaleStoreThread sh11 = new WholesaleStoreThread(shop11);
        ObjectListener shop11listener = new ObjectListener(sh11, informationWindow, images);
        JLabel shop11label = new JLabel();
        shop11label.setBounds(955, 560, 180, 160);
        shop11label.addMouseListener(shop11listener);
        background.add(shop11label);
        sh11.start();
        
        WholesaleStore shop12 = new WholesaleStore(new Position(100,500),"Rzeźnix","area 3, nr 12",400);
        WholesaleStoreThread sh12 = new WholesaleStoreThread(shop12);
        ObjectListener shop12listener = new ObjectListener(sh12, informationWindow, images);
        JLabel shop12label = new JLabel();
        shop12label.setBounds(1100, 0, 160, 135);
        shop12label.addMouseListener(shop12listener);
        background.add(shop12label);
        sh12.start();
        

        
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
        wholesaleStoreList.add(shop10);
        wholesaleStoreList.add(shop11);
        wholesaleStoreList.add(shop12);

        
        Product prod1 = new Product(1, "a", "b", "2000.01.01");
        Product prod2 = new Product(1, "a", "b", "2000.01.01");
        Product prod3 = new Product(1, "a", "b", "2000.01.01");
        Product prod4 = new Product(1, "a", "b", "2000.01.01");
        Product prod5 = new Product(1, "a", "b", "2000.01.01");
        shop1.addProduct(prod1);
        shop1.addProduct(prod2);
        shop1.addProduct(prod3);
        shop1.addProduct(prod4);
        shop10.addProduct(prod1);
        shop10.addProduct(prod2);
        shop10.addProduct(prod3);
        
        Intersection intersection1 = new Intersection(new Position(648,520), new Position(814,352), supplierThreadList, clientThreadList);       
        //Intersection intersection1 = new Intersection(new Position(664,504), new Position(798,368));  
        //AREA1
        Intersection inter2 = new Intersection(new Position(-14,520), new Position(164,352), supplierThreadList, clientThreadList); 
        //Intersection inter3 = new Intersection(new Position(40,593), new Position(150,530)); 
        Intersection inter3 = new Intersection(new Position(0,0), new Position(0,0), supplierThreadList, clientThreadList); 
        //AREA2
        Intersection inter4 = new Intersection(new Position(648,690), new Position(814,541), supplierThreadList, clientThreadList);
        //AREA3
        Intersection inter5 = new Intersection(new Position(648,302), new Position(814,133), supplierThreadList, clientThreadList);
        Intersection inter6 = new Intersection(new Position(875,246), new Position(940,146), supplierThreadList, clientThreadList);
        //AREA4
        Intersection inter7 = new Intersection(new Position(1265,520), new Position(1439,352), supplierThreadList, clientThreadList);
        Intersection inter8 = new Intersection(new Position(1265,312), new Position(1423,175), supplierThreadList, clientThreadList);
        
        area1.add(intersection1);
        area1.add(inter2);
        area1.add(inter3);
        
        area2.add(intersection1);
        area2.add(inter4);
        
        area3.add(intersection1);
        area3.add(inter5);
        area3.add(inter6);
        
        area3.add(intersection1);
        area3.add(inter7);
        area3.add(inter8);
        

        //x = main intersection
        //SIDEWALK
        //AREA1
        sidewalkMap.put("0 x", new Street("0 x", new ArrayList(Arrays.asList(intersection1, inter2)), new ArrayList(Arrays.asList(
            new Position(132,140), new Position(132,384), new Position(680,384)))));
        sidewalkMap.put("x 0", new Street("x 0", new ArrayList(Arrays.asList(intersection1,inter2)), new ArrayList(Arrays.asList(
            new Position(680,488), new Position(18,488), new Position(18,140)))));
        
        sidewalkMap.put("1 x", new Street("1 x", new ArrayList(Arrays.asList(intersection1,inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,384), new Position(680,384)))));
        sidewalkMap.put("x 1", new Street("x 1", new ArrayList(Arrays.asList(intersection1,inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(680,488), new Position(132,488), new Position(132,657)))));
        
        sidewalkMap.put("2 x", new Street("2 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(415,325), new Position(415,384), new Position(680,384)))));
        sidewalkMap.put("x 2", new Street("x 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(680,488), new Position(304,488), new Position(304,325)))));
        
        sidewalkMap.put("0 1", new Street("0 1", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(132,140), new Position(132,657)))));
        sidewalkMap.put("1 0", new Street("1 0", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,140)))));
        
        sidewalkMap.put("0 2", new Street("0 2", new ArrayList(Arrays.asList(inter2)), new ArrayList(Arrays.asList(
            new Position(132,140), new Position(132,384), new Position(304,384), new Position(304,325)))));
        sidewalkMap.put("2 0", new Street("2 0", new ArrayList(Arrays.asList(inter2)), new ArrayList(Arrays.asList(
            new Position(415,325), new Position(415,488), new Position(18,488), new Position(18,140)))));
        
        sidewalkMap.put("1 2", new Street("0 2", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(18,657), new Position(18,384), new Position(304,384), new Position(304,325)))));
        sidewalkMap.put("2 1", new Street("2 0", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(415,325), new Position(415,488), new Position(132,488), new Position(132,657)))));
        
        //AREA2
        sidewalkMap.put("3 x", new Street("3 x", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(538,573), new Position(680,573), new Position(680,488)))));
        sidewalkMap.put("x 3", new Street("x 3", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(782,488), new Position(782,680), new Position(538,680)))));
        
        sidewalkMap.put("4 x", new Street("4 x", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(680,700), new Position(680,488)))));
        sidewalkMap.put("x 4", new Street("x 4", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(782,488), new Position(782,700)))));
        
        sidewalkMap.put("3 4", new Street("3 4", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(538,573), new Position(782,573), new Position(782,700)))));
        sidewalkMap.put("4 3", new Street("4 3", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(680,700), new Position(680,680), new Position(538,680)))));
        
        //AREA3
        sidewalkMap.put("5 x", new Street("5 x", new ArrayList(Arrays.asList(intersection1,inter5)), new ArrayList(Arrays.asList(
            new Position(645,165), new Position(782,165), new Position(782,384)))));
        sidewalkMap.put("x 5", new Street("x 5", new ArrayList(Arrays.asList(intersection1,inter5)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,270), new Position(610,270)))));
        
        sidewalkMap.put("6 x", new Street("6 x", new ArrayList(Arrays.asList(intersection1,inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(1020,270), new Position(782,270), new Position(782,384)))));
        sidewalkMap.put("x 6", new Street("x 6", new ArrayList(Arrays.asList(intersection1,inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(680,384), new Position(680,165), new Position(1020,165)))));
        
        sidewalkMap.put("5 6", new Street("5 6", new ArrayList(Arrays.asList(inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(645,165), new Position(1020,165)))));
        sidewalkMap.put("6 5", new Street("6 5", new ArrayList(Arrays.asList(inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(1020,270), new Position(610,270)))));
        
        //AREA4
        sidewalkMap.put("7 x", new Street("7 x", new ArrayList(Arrays.asList(intersection1,inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1407,165), new Position(1407,488), new Position(782,488)))));
        sidewalkMap.put("x 7", new Street("x 7", new ArrayList(Arrays.asList(intersection1,inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(782,384), new Position(1297,384), new Position(1297,165)))));
        
        sidewalkMap.put("8 x", new Street("8 x", new ArrayList(Arrays.asList(intersection1,inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1407,280), new Position(1407,488), new Position(782,488)))));
        sidewalkMap.put("x 8", new Street("x 8", new ArrayList(Arrays.asList(intersection1,inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(782,384), new Position(1297,384), new Position(1297,175), new Position(1463,175)))));
        
        sidewalkMap.put("9 x", new Street("9 x", new ArrayList(Arrays.asList(intersection1,inter7)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,488), new Position(782,488)))));
        sidewalkMap.put("x 9", new Street("x 9", new ArrayList(Arrays.asList(intersection1,inter7)), new ArrayList(Arrays.asList(
            new Position(782,384), new Position(1407,384), new Position(1407,560), new Position(1588,560),new Position(1588,669)))));
        
        sidewalkMap.put("7 8", new Street("7 8", new ArrayList(Arrays.asList(inter8)), new ArrayList(Arrays.asList(
            new Position(1407,165), new Position(1407,175), new Position(1463,175)))));
        sidewalkMap.put("8 7", new Street("8 7", new ArrayList(Arrays.asList(inter8)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1297,280), new Position(1297,165)))));
        
        sidewalkMap.put("7 9", new Street("7 9", new ArrayList(Arrays.asList(inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1407,165), new Position(1407,560), new Position(1588,560), new Position(1588,669)))));
        sidewalkMap.put("9 7", new Street("9 7", new ArrayList(Arrays.asList(inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,165)))));
        
        sidewalkMap.put("8 9", new Street("8 9", new ArrayList(Arrays.asList(inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1463,280), new Position(1407,280), new Position(1407,560), new Position(1588,560),new Position(1588,669)))));
        sidewalkMap.put("9 8", new Street("9 8", new ArrayList(Arrays.asList(inter7,inter8)), new ArrayList(Arrays.asList(
            new Position(1480,669), new Position(1297,669), new Position(1297,175), new Position(1463,175)))));
        
        
        //ROAD
        //AREA1
        roadMap.put("0 x", new Street("0 x", area1, new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,450), new Position(712,450)))));
        roadMap.put("x 0", new Street("x 0", area1, new ArrayList(Arrays.asList(
            new Position(712,419), new Position(94,419), new Position(94,178)))));
        
        roadMap.put("1 x", new Street("1 x", area1, new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,450), new Position(712,450)))));
        roadMap.put("x 1", new Street("x 1", area1, new ArrayList(Arrays.asList(
            new Position(712,419), new Position(62,419), new Position(62,637)))));
        
        roadMap.put("2 x", new Street("2 x", area1, new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,450), new Position(712,450)))));
        roadMap.put("x 2", new Street("x 2", area1, new ArrayList(Arrays.asList(
            new Position(712,419), new Position(379,419), new Position(379,330)))));
        
        roadMap.put("0 1", new Street("0 1", area1, new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,637)))));
        roadMap.put("1 0", new Street("1 0", area1, new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,178)))));
        
        roadMap.put("0 2", new Street("0 2", area1, new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,450), new Position(379,450), new Position(379,330)))));
        roadMap.put("2 0", new Street("2 0", area1, new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,419), new Position(94,419), new Position(94,178)))));
        
        roadMap.put("1 2", new Street("0 2", area1, new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,450), new Position(379,450), new Position(379,330)))));
        roadMap.put("2 1", new Street("2 0", area1, new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,419), new Position(62,419), new Position(62,637)))));
        
        //AREA2
        roadMap.put("3 x", new Street("3 x", area2, new ArrayList(Arrays.asList(
            new Position(550,642), new Position(744,642), new Position(744,450)))));
        roadMap.put("x 3", new Street("x 3", area2, new ArrayList(Arrays.asList(
            new Position(712,450), new Position(712,610), new Position(550,610)))));
        
        roadMap.put("4 x", new Street("4 x", area2, new ArrayList(Arrays.asList(
            new Position(744,680), new Position(744,450)))));
        roadMap.put("x 4", new Street("x 4", area2, new ArrayList(Arrays.asList(
            new Position(712,450), new Position(712,680)))));
        
        roadMap.put("3 4", new Street("3 4", area2, new ArrayList(Arrays.asList(
            new Position(550,642), new Position(712,642), new Position(712,680)))));
        roadMap.put("4 3", new Street("4 3", area2, new ArrayList(Arrays.asList(
            new Position(744,680), new Position(744,610), new Position(550,610)))));
        
        //AREA3
        roadMap.put("5 x", new Street("5 x", area3, new ArrayList(Arrays.asList(
            new Position(620,233), new Position(712,233), new Position(712,419)))));
        roadMap.put("x 5", new Street("x 5", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(744,419), new Position(744,201), new Position(620,201)))));
        
        roadMap.put("6 x", new Street("6 x", area3, new ArrayList(Arrays.asList(
            new Position(1010,201), new Position(712,201), new Position(712,419)))));
        roadMap.put("x 6", new Street("x 6", area3, new ArrayList(Arrays.asList(
            new Position(744,419), new Position(744,233), new Position(1010,233)))));
        
        roadMap.put("5 6", new Street("5 6", area3, new ArrayList(Arrays.asList(
            new Position(620,233), new Position(1010,233)))));
        roadMap.put("6 5", new Street("6 5", area3, new ArrayList(Arrays.asList(
            new Position(1010,201), new Position(620,201)))));
        
        //AREA4
        roadMap.put("7 x", new Street("7 x", area4, new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,419), new Position(744,419)))));
        roadMap.put("x 7", new Street("x 7", area4, new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1366,450), new Position(1366,159)))));
        
        roadMap.put("8 x", new Street("8 x", area4, new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1333,210), new Position(1333,419), new Position(744,419)))));
        roadMap.put("x 8", new Street("x 8", area4, new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1366,450), new Position(1366,242), new Position(1458,242)))));
        
        roadMap.put("9 x", new Street("9 x", area4, new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,419), new Position(744,419)))));
        roadMap.put("x 9", new Street("x 9", area4, new ArrayList(Arrays.asList(
            new Position(744,450), new Position(1333,450), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        
        roadMap.put("7 8", new Street("7 8", area4, new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,242), new Position(1458,242)))));
        roadMap.put("8 7", new Street("8 7", area4, new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1366,210), new Position(1366,159)))));
        
        roadMap.put("7 9", new Street("7 9", area4, new ArrayList(Arrays.asList(
            new Position(1333,159), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        roadMap.put("9 7", new Street("9 7", area4, new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,159)))));
        
        roadMap.put("8 9", new Street("8 9", area4, new ArrayList(Arrays.asList(
            new Position(1458,210), new Position(1333,210), new Position(1333,631), new Position(1514,631), new Position(1514,680)))));
        roadMap.put("9 8", new Street("9 8", area4, new ArrayList(Arrays.asList(
            new Position(1547,680), new Position(1547,599), new Position(1366,599), new Position(1366,242), new Position(1458,242)))));
        
        //wholesale stores
        //AREA1
        roadMap.put("x 10", new Street("x 10", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(712,419), new Position(62,419), new Position(62,576), new Position(276,576), new Position(276,640)))));
        roadMap.put("10 x", new Street("10 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(308,640), new Position(308,544), new Position(94,544), new Position(94,450), new Position(712,450)))));
        
        roadMap.put("0 10", new Street("0 10", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(62,178), new Position(62,576), new Position(276,576), new Position(276,640)))));
        roadMap.put("10 0", new Street("10 0", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(308,640), new Position(308,544), new Position(94,544), new Position(94,178)))));
        
        roadMap.put("1 10", new Street("1 10", new ArrayList(Arrays.asList(inter3)), new ArrayList(Arrays.asList(
            new Position(94,637), new Position(94,576), new Position(276,576), new Position(276,640)))));
        roadMap.put("10 1", new Street("10 1", new ArrayList(Arrays.asList(inter3)), new ArrayList(Arrays.asList(
            new Position(308,640), new Position(308,544), new Position(62,544), new Position(62,637)))));
        
        roadMap.put("2 10", new Street("2 10", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(347,330), new Position(347,419), new Position(62,419), new Position(62,576), new Position(276,576), new Position(276,640)))));
        roadMap.put("10 2", new Street("10 2", new ArrayList(Arrays.asList(inter2,inter3)), new ArrayList(Arrays.asList(
            new Position(308,640), new Position(308,544), new Position(94,544), new Position(94,450), new Position(379,450), new Position(379,330)))));
        
        //AREA2
        roadMap.put("x 11", new Street("x 11", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(712,450), new Position(712,642), new Position(922,642)))));
        roadMap.put("11 x", new Street("11 x", new ArrayList(Arrays.asList(intersection1,inter4)), new ArrayList(Arrays.asList(
            new Position(922,610), new Position(744,610), new Position(744,450)))));
        
        roadMap.put("3 11", new Street("3 11", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(550,642), new Position(922,642)))));
        roadMap.put("11 3", new Street("11 3", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(922,610), new Position(550,610)))));
        
        roadMap.put("4 11", new Street("x 11", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(744,680), new Position(744,642), new Position(922,642)))));
        roadMap.put("11 4", new Street("11 x", new ArrayList(Arrays.asList(inter4)), new ArrayList(Arrays.asList(
            new Position(922,610), new Position(712,610), new Position(712,680)))));
        
        //AREA3
        roadMap.put("x 12", new Street("x 12", new ArrayList(Arrays.asList(intersection1,inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(744,419), new Position(744,233), new Position(922,233), new Position(922,95), new Position(1085,95)))));
        roadMap.put("12 x", new Street("12 x", new ArrayList(Arrays.asList(intersection1,inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(1085,63), new Position(890,63), new Position(890,201), new Position(712,201), new Position(712,419)))));
        
        roadMap.put("5 12", new Street("5 12", new ArrayList(Arrays.asList(inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(620,233), new Position(922,233), new Position(922,95), new Position(1085,95)))));
        roadMap.put("12 5", new Street("12 5", new ArrayList(Arrays.asList(inter5,inter6)), new ArrayList(Arrays.asList(
            new Position(1085,63), new Position(890,63), new Position(890,201), new Position(620,201)))));
        
        roadMap.put("6 12", new Street("6 12", new ArrayList(Arrays.asList(inter6)), new ArrayList(Arrays.asList(
            new Position(1010,201), new Position(922,201), new Position(922,95), new Position(1085,95)))));
        roadMap.put("12 6", new Street("12 6", new ArrayList(Arrays.asList(inter6)), new ArrayList(Arrays.asList(
            new Position(1085,63), new Position(890,63), new Position(890,233), new Position(1010,233)))));
        


        
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

        //System.out.println(informationWindow);
        boolean s=true;
        for(int i = 0; i < 20; i++){
            JLabel clientlabel1 = new JLabel(sickImage);
            clientlabel1.setBounds(18-16, 140-16, 32, 32);
            Client client1 = new Client(s,true,false,new Position(18,140),"a","a","a",10);
            clientList.add(client1);
            ClientThread c1 = new ClientThread(client1,adjacency,sidewalkMap,0,4, retailShopList, clientlabel1, images, clientList, controlPanel);

            ObjectListener clientListener1 = new ObjectListener(c1, informationWindow, images);
            clientlabel1.addMouseListener(clientListener1);
            background.add(clientlabel1);
            //ClientThread c1 = new ClientThread(client1,adjacency,sidewalkMap,0,1, retailShopList, clientlabel1, images);
            c1.start();
            clientThreadList.add(c1);
            s=!s;
            
        }

        
        JLabel supplierlabel1 = new JLabel(sickImage);
        supplierlabel1.setBounds(18-16, 140-16, 32, 32);
        Supplier supplier1 = new Supplier(false,true,false,new Position(18,140),1,"microsoft",new Car("ferrari",1,1,1),10,
            new ArrayList(Arrays.asList(0,1,10)));
        supplierList.add(supplier1);
        
        SupplierThread s1 = new SupplierThread(supplier1,adjacency,roadMap, retailShopList,wholesaleStoreList, supplierlabel1, images, supplierList, controlPanel);
        
        ObjectListener supplierListener = new ObjectListener(s1, informationWindow, images);
        supplierlabel1.addMouseListener(supplierListener);
        background.add(supplierlabel1);
        //SupplierThread s1 = new SupplierThread(supplier1,adjacency,roadMap, retailShopList, supplierlabel1, images);
        s1.start();
        supplierThreadList.add(s1);
        
        
       Painter painter = new Painter(images, clientThreadList, supplierThreadList);
       painter.start();
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
    

    
}




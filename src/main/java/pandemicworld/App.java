package pandemicworld;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
//import java.util.HashMap;

public class App extends JFrame{

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Pandemic world!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
                
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      //  container.set
      
        ControlPanel controlPanel = new ControlPanel(0.6,0.4,0.1,0.5,2,5);
        
        //supplier1,adjacency,roadMap, retailShopList,wholesaleStoreList, supplierlabel1, images, supplierList, controlPanel
        ArrayList<Person> clientList = new ArrayList<>();
        ArrayList<Person> supplierList = new ArrayList<>();
        ArrayList<ClientThread> clientThreadList = new ArrayList<>();
        ArrayList<SupplierThread> supplierThreadList = new ArrayList<>();
        ArrayList<RetailShop> retailShopList = new ArrayList<>();
        ArrayList<WholesaleStore> wholesaleStoreList = new ArrayList<>(); 
        ArrayList<ArrayList> adjacency = new ArrayList<>();
        HashMap<String, Street> sidewalkMap = new HashMap<String, Street>();;
        HashMap<String, Street> roadMap = new HashMap<String, Street>();;
        HashMap<String, ImageIcon> images = new HashMap<String, ImageIcon>();

        JLabel background = new JLabel();
        InformationWindow informationWindow = new InformationWindow(controlPanel, clientList, supplierList,
        clientThreadList, supplierThreadList, retailShopList, wholesaleStoreList,
        adjacency, sidewalkMap, roadMap, images, background);
        informationWindow.setPreferredSize(new Dimension(200,800));
        
        Map map = new Map(informationWindow, controlPanel, clientList, supplierList,
        clientThreadList, supplierThreadList, retailShopList, wholesaleStoreList,
        adjacency, sidewalkMap, roadMap, images, background);
        map.setPreferredSize(new Dimension(1600,800));
        map.setLayout(null);
        //JLabel background = new JLabel(sickImage);

        
        //JButton myButton = new JButton("My Button");
        

        
        //JLabel jlabel = new JLabel("This is a label");
        //jlabel.setFont(new Font("Verdana",1,20));
        //jlabel.setText("dqwdqwd");
        
        //InformationWindow informationWindow = new InformationWindow();
        //informationWindow.setPreferredSize(new Dimension(200,800));
      
        container.add(map);
        container.add(informationWindow);
        //container.add(myButton);
        //container.add(jlabel);
        //map.add(jlabeltest);
        
        frame.getContentPane().add(container);

        //frame.setPreferredSize(new Dimension(1800,850));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


        
    }
}


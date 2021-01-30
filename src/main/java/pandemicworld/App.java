package pandemicworld;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Main class
 */
public class App extends JFrame {

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Pandemic world!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        int numOfClients = 30;
        ControlPanel controlPanel = new ControlPanel(0.6, 0.4, 0.1, 0.5, 2, 5, numOfClients);

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
        informationWindow.setPreferredSize(new Dimension(200, 800));

        Map map = new Map(informationWindow, controlPanel, clientList, supplierList,
                clientThreadList, supplierThreadList, retailShopList, wholesaleStoreList,
                adjacency, sidewalkMap, roadMap, images, background);
        map.setPreferredSize(new Dimension(1600, 800));
        map.setLayout(null);

        container.add(map);
        container.add(informationWindow);

        frame.getContentPane().add(container);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }
}

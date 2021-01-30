package pandemicworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Thread that operates client.
 *
 */
public class ClientThread extends Thread {

    private Client client;
    private ArrayList<ArrayList> adjacency;
    private ArrayList<RetailShop> retailShopList;
    private ArrayList<Person> clientsList;
    private HashMap<String, Street> sidewalkMap;
    private HashMap<String, ImageIcon> images;
    private int from, to;
    private Street currentSidewalk;
    private boolean next = false;
    private JLabel icon;
    private ControlPanel controlPanel;
    private int visitsToRecover;

    public ClientThread(Client client, ArrayList<ArrayList> adjacency, HashMap<String, Street> sidewalkMap, int from, int to, ArrayList<RetailShop> retailShopList,
            JLabel icon, HashMap<String, ImageIcon> images, ArrayList<Person> clientsList, ControlPanel controlPanel) {
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
    }

    public JLabel getIcon() {
        return icon;
    }

    public Client getClient() {
        return client;
    }

    /**
     * If the shop to which the client is going is in another area, first he
     * goes to the main intersection "x".
     */
    @Override
    public void run() {

        while (true) {
            if (visitsToRecover < 0 && client.getSick()) {
                visitsToRecover = controlPanel.getVisitsBeforeRecover();
                client.setSick(true);
            }

            if (visitsToRecover == 0 && client.getSick()) {
                client.setSick(false);
            }

            if (next == true) {

                currentSidewalk = sidewalkMap.get("x " + Integer.toString(to));
                next = false;

            } else if (adjacency.get(from).get(to).equals(1)) {

                currentSidewalk = sidewalkMap.get(Integer.toString(from) + " " + Integer.toString(to));

            } else {

                next = true;
                currentSidewalk = sidewalkMap.get(Integer.toString(from) + " x");

            }

            client.travel(currentSidewalk, clientsList, 16);

            //next shop
            if (next == false) {
                visitsToRecover--;
                try {

                    if (client.getSick()) {
                        if (client.getMask()) {
                            client.infect(retailShopList.get(to), controlPanel.getTransRateMask(), controlPanel.getTransIfVacc());
                        } else {
                            client.infect(retailShopList.get(to), controlPanel.getTransRate(), controlPanel.getTransIfVacc());
                        }
                    }

                    client.buy(retailShopList.get(to), icon);
                    client.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
                from = to;
                to = client.nextShop();

            }

        }

    }
}

package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InformationWindow extends JPanel {

    private ControlPanel control;

    private JPanel currentPanel;
    private JPanel clientPanel;
    private JPanel supplierPanel;
    private JPanel retailShopPanel;
    private JPanel wholesaleStorePanel;
    private JPanel controlPanel;
    private JPanel addPanel;

    private JLabel iconClientLabel;
    private JLabel iconSupplierLabel;
    private JLabel iconRetailShopLabel;
    private JLabel iconWholesaleStoreLabel;

    private JLabel vaccinatedClientLabel;
    private JLabel positionClientLabel;
    private JLabel numOfProductsClientLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel SSNLabel;
    private JLabel nextShopLabel;

    private JLabel vaccinatedSupplierLabel;
    private JLabel positionSupplierLabel;
    private JLabel numOfProductsSupplierLabel;
    private JLabel IDLabel;
    private JLabel companyLabel;
    private JLabel carBrandLabel;
    private JLabel routeLabel;
    private JLabel gasLabel;

    private JLabel clientsNowLabel;
    private JLabel lockdownLabel;
    private JLabel peopleCapacityRetailLabel;
    private JLabel storageCapacityRetailLabel;
    private JLabel addressRetailLabel;
    private JLabel supplySizeRetailLabel;

    private JLabel addressWholesaleLabel;
    private JLabel storageCapacityWholesaleLabel;
    private JLabel supplySizeWholesaleLabel;
    private JLabel typesOfProductLabel;

    private JLabel transRateLabel;
    private JLabel transRateMaskLabel;
    private JLabel transIfVaccLabel;
    private JLabel lockdownTresholdLabel;
    private JLabel visitsBeforeRecoverLabel;
    private JLabel numOfVaccLabel;

    private JButton stopClientButton;
    private JButton stopSupplierButton;
    private JButton changeToAddButton;
    private JButton changeToControlButton;

    private JLabel clientDataLabel;
    private JLabel supplierDataLabel;

    private JTextField routeField;
    private JTextField addProductField;
    private JTextField transRateField;
    private JTextField transRateMaskField;
    private JTextField transIfVaccField;
    private JTextField lockdownTresholdField;
    private JTextField visitsBeforeRecoverField;
    private JTextField numOfVaccField;

    private JTextField clientDataField;
    private JTextField supplierDataField;

    private String currentObject;
    private Client client;
    private Supplier supplier;
    private RetailShop retailShop;
    private WholesaleStore wholesaleStore;

    private ArrayList<Person> clientList;
    private ArrayList<Person> supplierList;
    private ArrayList<ClientThread> clientThreadList;
    private ArrayList<SupplierThread> supplierThreadList;
    private ArrayList<RetailShop> retailShopList;
    private ArrayList<WholesaleStore> wholesaleStoreList;
    private ArrayList<ArrayList> adjacency;
    private HashMap<String, Street> sidewalkMap;
    private HashMap<String, Street> roadMap;
    private HashMap<String, ImageIcon> images;

    private JLabel background;
    private InformationWindow infWindow = this;

    public InformationWindow(ControlPanel control, ArrayList<Person> clientList,
            ArrayList<Person> supplierList, ArrayList<ClientThread> clientThreadList,
            ArrayList<SupplierThread> supplierThreadList, ArrayList<RetailShop> retailShopList,
            ArrayList<WholesaleStore> wholesaleStoreList, ArrayList<ArrayList> adjacency,
            HashMap<String, Street> sidewalkMap, HashMap<String, Street> roadMap, HashMap<String, ImageIcon> images, JLabel background) {

        setBackground(Color.GRAY);
        setFocusable(true);
        this.clientList = clientList;
        this.supplierList = supplierList;
        this.retailShopList = retailShopList;
        this.wholesaleStoreList = wholesaleStoreList;
        this.adjacency = adjacency;
        this.sidewalkMap = sidewalkMap;
        this.roadMap = roadMap;
        this.clientThreadList = clientThreadList;
        this.supplierThreadList = supplierThreadList;
        this.images = images;
        this.background = background;

        this.control = control;

        currentPanel = new JPanel();
        clientPanel = new JPanel();
        supplierPanel = new JPanel();
        retailShopPanel = new JPanel();
        wholesaleStorePanel = new JPanel();
        controlPanel = new JPanel();
        addPanel = new JPanel();

        clientPanel.setVisible(false);
        supplierPanel.setVisible(false);
        retailShopPanel.setVisible(false);
        wholesaleStorePanel.setVisible(false);
        addPanel.setVisible(false);

        clientPanel.setPreferredSize(new Dimension(200, 450));
        supplierPanel.setPreferredSize(new Dimension(200, 450));
        retailShopPanel.setPreferredSize(new Dimension(200, 450));
        wholesaleStorePanel.setPreferredSize(new Dimension(200, 450));
        controlPanel.setPreferredSize(new Dimension(200, 350));
        addPanel.setPreferredSize(new Dimension(200, 350));

        this.add(clientPanel);
        this.add(supplierPanel);
        this.add(retailShopPanel);
        this.add(wholesaleStorePanel);
        this.add(controlPanel);
        this.add(addPanel);

        iconClientLabel = new JLabel();
        iconSupplierLabel = new JLabel();
        iconRetailShopLabel = new JLabel();
        iconWholesaleStoreLabel = new JLabel();

        int fsize = 12;

        vaccinatedClientLabel = new JLabel();
        vaccinatedClientLabel.setPreferredSize(new Dimension(200, 25));
        vaccinatedClientLabel.setFont(new Font("Verdana", 1, fsize));
        positionClientLabel = new JLabel();
        positionClientLabel.setPreferredSize(new Dimension(200, 25));
        positionClientLabel.setFont(new Font("Verdana", 1, fsize));
        numOfProductsClientLabel = new JLabel();
        numOfProductsClientLabel.setPreferredSize(new Dimension(200, 25));
        numOfProductsClientLabel.setFont(new Font("Verdana", 1, fsize));
        firstNameLabel = new JLabel();
        firstNameLabel.setPreferredSize(new Dimension(200, 25));
        firstNameLabel.setFont(new Font("Verdana", 1, fsize));
        lastNameLabel = new JLabel();
        lastNameLabel.setPreferredSize(new Dimension(200, 25));
        lastNameLabel.setFont(new Font("Verdana", 1, fsize));
        SSNLabel = new JLabel();
        SSNLabel.setPreferredSize(new Dimension(200, 25));
        SSNLabel.setFont(new Font("Verdana", 1, fsize));
        nextShopLabel = new JLabel();
        nextShopLabel.setPreferredSize(new Dimension(200, 25));
        nextShopLabel.setFont(new Font("Verdana", 1, fsize));

        vaccinatedSupplierLabel = new JLabel();
        vaccinatedSupplierLabel.setPreferredSize(new Dimension(200, 25));
        vaccinatedSupplierLabel.setFont(new Font("Verdana", 1, fsize));
        positionSupplierLabel = new JLabel();
        positionSupplierLabel.setPreferredSize(new Dimension(200, 25));
        positionSupplierLabel.setFont(new Font("Verdana", 1, fsize));
        numOfProductsSupplierLabel = new JLabel();
        numOfProductsSupplierLabel.setPreferredSize(new Dimension(200, 25));
        numOfProductsSupplierLabel.setFont(new Font("Verdana", 1, fsize));
        IDLabel = new JLabel();
        IDLabel.setPreferredSize(new Dimension(200, 25));
        IDLabel.setFont(new Font("Verdana", 1, fsize));
        companyLabel = new JLabel();
        companyLabel.setPreferredSize(new Dimension(200, 25));
        companyLabel.setFont(new Font("Verdana", 1, fsize));
        carBrandLabel = new JLabel();
        carBrandLabel.setPreferredSize(new Dimension(200, 25));
        carBrandLabel.setFont(new Font("Verdana", 1, fsize));
        routeLabel = new JLabel();
        routeLabel.setPreferredSize(new Dimension(200, 25));
        routeLabel.setFont(new Font("Verdana", 1, fsize));
        gasLabel = new JLabel();
        gasLabel.setPreferredSize(new Dimension(200, 25));
        gasLabel.setFont(new Font("Verdana", 1, fsize));

        clientsNowLabel = new JLabel();
        clientsNowLabel.setPreferredSize(new Dimension(200, 25));
        clientsNowLabel.setFont(new Font("Verdana", 1, fsize));
        lockdownLabel = new JLabel();
        lockdownLabel.setPreferredSize(new Dimension(200, 25));
        lockdownLabel.setFont(new Font("Verdana", 1, fsize));
        peopleCapacityRetailLabel = new JLabel();
        peopleCapacityRetailLabel.setPreferredSize(new Dimension(200, 25));
        peopleCapacityRetailLabel.setFont(new Font("Verdana", 1, fsize));
        storageCapacityRetailLabel = new JLabel();
        storageCapacityRetailLabel.setPreferredSize(new Dimension(200, 25));
        storageCapacityRetailLabel.setFont(new Font("Verdana", 1, fsize));
        addressRetailLabel = new JLabel();
        addressRetailLabel.setPreferredSize(new Dimension(200, 25));
        addressRetailLabel.setFont(new Font("Verdana", 1, fsize));
        supplySizeRetailLabel = new JLabel();
        supplySizeRetailLabel.setPreferredSize(new Dimension(200, 25));
        supplySizeRetailLabel.setFont(new Font("Verdana", 1, fsize));

        addressWholesaleLabel = new JLabel();
        addressWholesaleLabel.setPreferredSize(new Dimension(200, 25));
        addressWholesaleLabel.setFont(new Font("Verdana", 1, fsize));
        storageCapacityWholesaleLabel = new JLabel();
        storageCapacityWholesaleLabel.setPreferredSize(new Dimension(200, 25));
        storageCapacityWholesaleLabel.setFont(new Font("Verdana", 1, fsize));
        supplySizeWholesaleLabel = new JLabel();
        supplySizeWholesaleLabel.setPreferredSize(new Dimension(200, 25));
        supplySizeWholesaleLabel.setFont(new Font("Verdana", 1, fsize));
        typesOfProductLabel = new JLabel();
        typesOfProductLabel.setPreferredSize(new Dimension(200, 25));
        typesOfProductLabel.setFont(new Font("Verdana", 1, fsize));

        transRateLabel = new JLabel();
        transRateLabel.setPreferredSize(new Dimension(100, 25));
        transRateLabel.setFont(new Font("Verdana", 1, fsize));
        transRateLabel.setText("<html>transmission rate: " + String.valueOf(control.getTransRate()) + "</html>");
        transRateMaskLabel = new JLabel();
        transRateMaskLabel.setPreferredSize(new Dimension(200, 25));
        transRateMaskLabel.setFont(new Font("Verdana", 1, fsize));
        transRateMaskLabel.setText("<html>transmission with mask rate: " + String.valueOf(control.getTransRateMask()) + "</html>");
        transIfVaccLabel = new JLabel();
        transIfVaccLabel.setPreferredSize(new Dimension(200, 25));
        transIfVaccLabel.setFont(new Font("Verdana", 1, fsize));
        transIfVaccLabel.setText("<html>transmission vaccinated rate: " + String.valueOf(control.getTransIfVacc()) + "</html>");
        lockdownTresholdLabel = new JLabel();
        lockdownTresholdLabel.setPreferredSize(new Dimension(200, 25));
        lockdownTresholdLabel.setFont(new Font("Verdana", 1, fsize));
        lockdownTresholdLabel.setText("<html>lockdown treshold: " + String.valueOf(control.getLockDownTreshold()) + "</html>");
        visitsBeforeRecoverLabel = new JLabel();
        visitsBeforeRecoverLabel.setPreferredSize(new Dimension(200, 25));
        visitsBeforeRecoverLabel.setFont(new Font("Verdana", 1, fsize));
        visitsBeforeRecoverLabel.setText("<html>visits before recovery: " + Integer.toString(control.getVisitsBeforeRecover()) + "</html>");
        numOfVaccLabel = new JLabel();
        numOfVaccLabel.setPreferredSize(new Dimension(200, 25));
        numOfVaccLabel.setFont(new Font("Verdana", 1, fsize));
        numOfVaccLabel.setText("<html>number of vaccinated people: " + Integer.toString(control.getNumOfVacc()) + "</html>");

        stopClientButton = new JButton();
        stopClientButton.setText("DELETE");
        stopClientButton.setFont(new Font("Arial", Font.PLAIN, 18));
        stopSupplierButton = new JButton();
        stopSupplierButton.setText("DELETE");
        stopSupplierButton.setFont(new Font("Arial", Font.PLAIN, 18));
        changeToAddButton = new JButton();
        changeToAddButton.setText("ADD");
        changeToAddButton.setFont(new Font("Arial", Font.BOLD, 15));
        changeToAddButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controlPanel.setVisible(false);
                addPanel.setVisible(true);
            }
        });

        routeField = new JTextField();
        addProductField = new JTextField();

        transRateField = new JTextField();
        transRateField.setText(String.valueOf(control.getTransRate()));
        transRateField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = transRateField.getText();
                transRateLabel.setText("<html>transmission rate: " + input + "</html>");
                control.setTransRate(Double.parseDouble(input));
            }
        });

        transRateMaskField = new JTextField();
        transRateMaskField.setText(String.valueOf(control.getTransRateMask()));
        transRateMaskField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = transRateMaskField.getText();
                transRateMaskLabel.setText("<html>transmission with mask rate: " + input + "</html>");
                control.setTransRateMask(Double.parseDouble(input));
            }
        });

        transIfVaccField = new JTextField();
        transIfVaccField.setText(String.valueOf(control.getTransIfVacc()));
        transIfVaccField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = transIfVaccField.getText();
                transIfVaccLabel.setText("<html>transmission vaccinated rate: " + input + "</html>");
                control.setTransIfVacc(Double.parseDouble(input));
            }
        });

        lockdownTresholdField = new JTextField();
        lockdownTresholdField.setText(String.valueOf(control.getLockDownTreshold()));
        lockdownTresholdField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = lockdownTresholdField.getText();
                lockdownTresholdLabel.setText("<html>lockdown treshold: " + input + "</html>");
                control.setLockdownTeshold(Double.parseDouble(input));
            }
        });

        visitsBeforeRecoverField = new JTextField();
        visitsBeforeRecoverField.setText(Integer.toString(control.getVisitsBeforeRecover()));
        visitsBeforeRecoverField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = visitsBeforeRecoverField.getText();
                visitsBeforeRecoverLabel.setText("<html>visits before recovery: " + input + "</html>");
                control.setVisitsBeforeRecover(Integer.parseInt(input));
            }
        });

        numOfVaccField = new JTextField();
        numOfVaccField.setText(Integer.toString(control.getNumOfVacc()));
        numOfVaccField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = numOfVaccField.getText();
                numOfVaccLabel.setText("<html>number of vaccinated people: " + input + "</html>");
                control.setNumOfVacc(Integer.parseInt(input));

                for (int i = 0; i < clientList.size(); i++) {
                    clientList.get(i).setVaccinated(false);
                }
                for (int i = 0; i < clientList.size(); i++) {
                    if (i < control.getNumOfVacc()) {
                        clientList.get(i).setVaccinated(true);
                    }
                }
            }
        });

        changeToControlButton = new JButton();
        changeToControlButton.setText("CONTROL");
        changeToControlButton.setFont(new Font("Arial", Font.BOLD, 15));
        changeToControlButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addPanel.setVisible(false);
                controlPanel.setVisible(true);
            }
        });

        clientDataLabel = new JLabel();
        clientDataLabel.setPreferredSize(new Dimension(200, 60));
        clientDataLabel.setFont(new Font("Verdana", 1, fsize));
        clientDataLabel.setText("<html>CLIENT: sick, mask, vaccinated, start shop index,"
                + " name, surname, SSN, cart capacity</html>");

        supplierDataLabel = new JLabel();
        supplierDataLabel.setPreferredSize(new Dimension(200, 80));
        supplierDataLabel.setFont(new Font("Verdana", 1, fsize));
        supplierDataLabel.setText("<html>SUPPLIER: sick, mask, vaccinated, start shop index, ID,"
                + "company, car brand, trunk capacity; route has default value, but you can change</html>");

        clientDataField = new JTextField();
        clientDataField.setPreferredSize(new Dimension(200, 25));
        clientDataField.setText("true, false, false, 0, Jerzy, Zięba, 123-45-6789, 10");

        supplierDataField = new JTextField();
        supplierDataField.setPreferredSize(new Dimension(200, 25));
        supplierDataField.setText("true, false, false, 0, 123, Transpol, golf, 100");

        clientDataField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = clientDataField.getText();
                String[] inputs = input.split(", ");
                boolean sick, mask, vacc;
                int shopIndex, cartCapacity;
                String firstName, lastName, SSN;

                sick = Boolean.parseBoolean(inputs[0]);
                mask = Boolean.parseBoolean(inputs[1]);
                vacc = Boolean.parseBoolean(inputs[2]);
                shopIndex = Integer.parseInt(inputs[3]);
                Position position = new Position(retailShopList.get(shopIndex).getExit().getX(),
                        retailShopList.get(shopIndex).getExit().getY());
                firstName = inputs[4];
                lastName = inputs[5];
                SSN = inputs[6];
                cartCapacity = Integer.parseInt(inputs[7]);

                Client newClient = new Client(sick, mask, vacc, position, firstName,
                        lastName, SSN, cartCapacity);

                JLabel clientLabel = new JLabel();
                clientList.add(newClient);
                ClientThread newC = new ClientThread(newClient, adjacency, sidewalkMap,
                        shopIndex, newClient.nextShop(), retailShopList, clientLabel, images, clientList,
                        control);
                ObjectListener clientListener = new ObjectListener(newC, infWindow);
                clientLabel.addMouseListener(clientListener);
                background.add(clientLabel);
                newC.start();
                clientThreadList.add(newC);
            }
        });

        supplierDataField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = supplierDataField.getText();
                String[] inputs = input.split(", ");
                boolean sick, mask, vacc;
                int shopIndex, trunkCapacity, ID;
                String company, brand;

                sick = Boolean.parseBoolean(inputs[0]);
                mask = Boolean.parseBoolean(inputs[1]);
                vacc = Boolean.parseBoolean(inputs[2]);
                shopIndex = Integer.parseInt(inputs[3]);
                Position position = new Position(retailShopList.get(shopIndex).getExit().getX(),
                        retailShopList.get(shopIndex).getExit().getY());

                ID = Integer.parseInt(inputs[4]);
                company = inputs[5];
                brand = inputs[6];
                trunkCapacity = Integer.parseInt(inputs[7]);

                Car car = new Car(brand, 100, 0.1, 100);
                ArrayList<Integer> route = new ArrayList<Integer>();
                route.add(0);
                route.add(1);
                route.add(10);

                Supplier newSupplier = new Supplier(sick, mask, vacc, position,
                        ID, company, car, trunkCapacity, route);

                JLabel supplierLabel = new JLabel();
                supplierList.add(newSupplier);
                SupplierThread newS = new SupplierThread(newSupplier, adjacency, roadMap,
                        retailShopList, wholesaleStoreList, supplierLabel, images, supplierList, control);
                ObjectListener supplierListener = new ObjectListener(newS, infWindow);
                supplierLabel.addMouseListener(supplierListener);
                background.add(supplierLabel);
                newS.start();
                supplierThreadList.add(newS);
            }
        });

        clientPanel.add(iconClientLabel);
        clientPanel.add(vaccinatedClientLabel);
        clientPanel.add(positionClientLabel);
        clientPanel.add(numOfProductsClientLabel);
        clientPanel.add(firstNameLabel);
        clientPanel.add(lastNameLabel);
        clientPanel.add(SSNLabel);
        clientPanel.add(nextShopLabel);
        clientPanel.add(stopClientButton);

        supplierPanel.add(iconSupplierLabel);
        supplierPanel.add(vaccinatedSupplierLabel);
        supplierPanel.add(positionSupplierLabel);
        supplierPanel.add(numOfProductsSupplierLabel);
        supplierPanel.add(IDLabel);
        supplierPanel.add(companyLabel);
        supplierPanel.add(carBrandLabel);
        supplierPanel.add(gasLabel);
        supplierPanel.add(routeLabel);
        supplierPanel.add(routeField);
        supplierPanel.add(stopSupplierButton);

        retailShopPanel.add(iconRetailShopLabel);
        retailShopPanel.add(clientsNowLabel);
        retailShopPanel.add(lockdownLabel);
        retailShopPanel.add(peopleCapacityRetailLabel);
        retailShopPanel.add(addressRetailLabel);
        retailShopPanel.add(supplySizeRetailLabel);

        wholesaleStorePanel.add(iconWholesaleStoreLabel);
        wholesaleStorePanel.add(addressWholesaleLabel);
        wholesaleStorePanel.add(storageCapacityWholesaleLabel);
        wholesaleStorePanel.add(supplySizeWholesaleLabel);
        wholesaleStorePanel.add(typesOfProductLabel);
        wholesaleStorePanel.add(addProductField);

        controlPanel.add(transRateLabel);
        controlPanel.add(changeToAddButton);
        controlPanel.add(transRateField);
        controlPanel.add(transRateMaskLabel);
        controlPanel.add(transRateMaskField);
        controlPanel.add(transIfVaccLabel);
        controlPanel.add(transIfVaccField);
        controlPanel.add(lockdownTresholdLabel);
        controlPanel.add(lockdownTresholdField);
        controlPanel.add(visitsBeforeRecoverLabel);
        controlPanel.add(visitsBeforeRecoverField);
        controlPanel.add(numOfVaccLabel);
        controlPanel.add(numOfVaccField);

        addPanel.add(changeToControlButton);
        addPanel.add(clientDataLabel);
        addPanel.add(clientDataField);
        addPanel.add(supplierDataLabel);
        addPanel.add(supplierDataField);

        Refresher ref = new Refresher();
        ref.start();
    }

    /**
     * Generates informations about a client.
     *
     */
    public void refreshClient(ClientThread clientThread) {
        client = clientThread.getClient();
        currentPanel.setVisible(false);
        currentPanel = clientPanel;
        currentPanel.setVisible(true);
        currentObject = "client";

        if (client.getMask() == true) {
            if (client.getSick() == true) {
                ImageIcon icon = new ImageIcon(images.get("sickMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            } else {
                ImageIcon icon = new ImageIcon(images.get("healthyMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            }
        } else {
            if (client.getSick() == true) {
                ImageIcon icon = new ImageIcon(images.get("sickImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            } else {
                ImageIcon icon = new ImageIcon(images.get("healthyImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            }
        }

        vaccinatedClientLabel.setText("<html>Vaccinated: " + Boolean.toString(client.getVaccinated()) + "</html>");
        positionClientLabel.setText("<html>X: " + Integer.toString(client.getPosition().getX()) + " Y: " + Integer.toString(client.getPosition().getY()) + "</html>");
        numOfProductsClientLabel.setText("<html>Number of products: " + Integer.toString(client.getCart().size()) + "</html>");
        firstNameLabel.setText("<html>First name: " + client.getFirstName() + "</html>");
        lastNameLabel.setText("<html>Last name: " + client.getLastName() + "</html>");
        SSNLabel.setText("<html>SSN: " + client.getSSN() + "</html>");
        nextShopLabel.setText("<html>Next shop: " + client.getNextShop() + "</html>");

        stopClientButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientThread.stop();
                clientThread.getIcon().setVisible(false);
                client.resetPosition();
                if (client.getAtIntersection()) {
                    client.getCurrentIntersection().setAvailable(true);
                }
                client.setInShop(false);

            }
        });
    }

    /**
     * Generates informations about a supplier.
     *
     */
    public void refreshSupplier(SupplierThread supplierThread) {
        supplier = supplierThread.getSupplier();
        currentPanel.setVisible(false);
        currentPanel = supplierPanel;
        currentPanel.setVisible(true);
        currentObject = "supplier";

        if (supplier.getCar().getBrand().equals("ferrari")) {
            ImageIcon icon = new ImageIcon(images.get("ferrariRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        } else if (supplier.getCar().getBrand().equals("golf")) {
            ImageIcon icon = new ImageIcon(images.get("golfRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon(images.get("carRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        }

        vaccinatedSupplierLabel.setText("<html>Vaccinated: " + Boolean.toString(supplier.getVaccinated()) + "</html>");
        positionSupplierLabel.setText("<html>X: " + Integer.toString(supplier.getPosition().getX()) + " Y: " + Integer.toString(supplier.getPosition().getY()) + "</html>");
        numOfProductsSupplierLabel.setText("<html>Number of products: " + Integer.toString(supplier.getTrunk().size()) + "</html>");
        IDLabel.setText("<html>ID: " + Integer.toString(supplier.getID()) + "</html>");
        companyLabel.setText("<html>Company: " + supplier.getCompany() + "</html>");
        carBrandLabel.setText("<html>Car brand: " + supplier.getCar().getBrand() + "</html>");
        routeLabel.setText("<html>Route: " + supplier.getRoute() + " (one warehouse)</html>");
        gasLabel.setText("<html>Gas: " + supplier.getCar().getGas() + "</html>");

        routeField.setText(supplier.getRoute().toString().substring(1, supplier.getRoute().toString().length() - 1));

        routeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = routeField.getText();
                String[] inputs = input.split(", ");
                ArrayList<Integer> newRoute = new ArrayList<Integer>();

                for (int i = 0; i < inputs.length; i++) {
                    newRoute.add(Integer.parseInt(inputs[i]));
                }
                supplier.setRoute(newRoute);

            }
        });

        stopSupplierButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                supplierThread.stop();
                supplierThread.getIcon().setVisible(false);
                supplier.resetPosition();
                if (supplier.getAtIntersection()) {
                    supplier.getCurrentIntersection().setAvailable(true);
                }
                supplier.setInShop(false);
            }
        });

    }

    /**
     * Generates informations about retail shop.
     *
     */
    public void refreshRetailShop(RetailShopThread retailShopThread) {
        retailShop = retailShopThread.getRetailShop();
        currentPanel.setVisible(false);
        currentPanel = retailShopPanel;
        currentPanel.setVisible(true);
        currentObject = "retail";

        ImageIcon icon = new ImageIcon(images.get("retailShopImage").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT));
        iconRetailShopLabel.setIcon(icon);

        clientsNowLabel.setText("<html>Clients in shop: " + Integer.toString(retailShop.getClientsNow()) + "</html>");
        lockdownLabel.setText("<html>Lockdown: " + Boolean.toString(retailShop.getLockdown()) + "</html>");
        peopleCapacityRetailLabel.setText("<html>Max people: " + Integer.toString(retailShop.getClientCapacity()) + "</html>");
        storageCapacityRetailLabel.setText("<html>Storage capacity: " + Integer.toString(retailShop.getStorageCapacity()) + "</html>");
        addressRetailLabel.setText("<html>Address: " + retailShop.getAddress() + "</html>");
        supplySizeRetailLabel.setText("<html>Num of products: " + Integer.toString(retailShop.getCurrentSupply().size()) + "</html>");

    }

    /**
     * Generates informations about wholesale store.
     *
     * @param wholesaleStoreThread
     */
    public void refreshWholesaleStore(WholesaleStoreThread wholesaleStoreThread) {
        wholesaleStore = wholesaleStoreThread.getWholesaleStore();
        currentPanel.setVisible(false);
        currentPanel = wholesaleStorePanel;
        currentPanel.setVisible(true);
        currentObject = "wholesale";

        ImageIcon icon = new ImageIcon(images.get("wholesaleStoreImage").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT));
        iconWholesaleStoreLabel.setIcon(icon);

        addressWholesaleLabel.setText("<html>Address: " + wholesaleStore.getAddress() + "</html>");
        storageCapacityWholesaleLabel.setText("<html>Storage capacity: " + Integer.toString(wholesaleStore.getStorageCapacity()) + "</html>");
        supplySizeWholesaleLabel.setText("<html>Num of products: " + Integer.toString(wholesaleStore.getCurrentSupply().size()) + "</html>");
        typesOfProductLabel.setText("<html>Types of products: " + Integer.toString(wholesaleStore.getTypesOfProducts().size()) + "</html>");

        addProductField.setText("ID, name, brand, price");

        addProductField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = addProductField.getText();
                String[] inputs = input.split(", ");
                wholesaleStore.createProduct(Integer.parseInt(inputs[0]), inputs[1], inputs[2], Double.parseDouble(inputs[4]));
            }
        });
    }

    class Refresher extends Thread {

        @Override
        public void run() {
            while (true) {
                if (currentObject != null) {
                    switch (currentObject) {
                        case "client":
                            positionClientLabel.setText("<html>X: " + Integer.toString(client.getPosition().getX()) + " Y: " + Integer.toString(client.getPosition().getY()) + "</html>");
                            numOfProductsClientLabel.setText("<html>Number of products: " + Integer.toString(client.getCart().size()) + "</html>");
                            nextShopLabel.setText("<html>Next shop: " + client.getNextShop() + "</html>");
                            break;
                        case "supplier":
                            positionSupplierLabel.setText("<html>X: " + Integer.toString(supplier.getPosition().getX()) + " Y: " + Integer.toString(supplier.getPosition().getY()) + "</html>");
                            numOfProductsSupplierLabel.setText("<html>Number of products: " + Integer.toString(supplier.getTrunk().size()) + "</html>");
                            routeLabel.setText("<html>Route: " + supplier.getRoute() + " (one warehouse)</html>");
                            gasLabel.setText("<html>Gas: " + supplier.getCar().getGas() + "</html>");
                            break;
                        case "retail":
                            peopleCapacityRetailLabel.setText("<html>Max people: " + Integer.toString(retailShop.getClientCapacity()) + "</html>");
                            clientsNowLabel.setText("<html>Clients in shop: " + Integer.toString(retailShop.getClientsNow()) + "</html>");
                            lockdownLabel.setText("<html>Lockdown: " + Boolean.toString(retailShop.getLockdown()) + "</html>");
                            supplySizeRetailLabel.setText("<html>Num of products: " + Integer.toString(retailShop.getCurrentSupply().size()) + "</html>");
                            break;
                        case "wholesale":
                            supplySizeWholesaleLabel.setText("<html>Num of products: " + Integer.toString(wholesaleStore.getCurrentSupply().size()) + "</html>");
                            typesOfProductLabel.setText("<html>Types of products: " + Integer.toString(wholesaleStore.getTypesOfProducts().size()) + "</html>");
                            break;
                    }
                }

                try {
                    sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(InformationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

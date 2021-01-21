
package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class InformationWindow extends JPanel {
    
    private JPanel currentPanel;
    private JPanel clientPanel;
    private JPanel supplierPanel;
    private JPanel retailShopPanel;
    private JPanel wholesaleStorePanel;
    
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
    
    private JLabel clientsNowLabel;
    private JLabel lockdownLabel;
    private JLabel peopleCapacityRetailLabel;
    private JLabel storageCapacityRetailLabel;
    private JLabel addressRetailLabel;
    private JLabel supplySizeRetailLabel;
    
    private JButton stopClientButton;
    private JButton stopSupplierButton;
    
    private JTextField routeField;
    
    public InformationWindow() {

        setBackground(Color.BLUE);
        setFocusable(true);

        currentPanel = new JPanel();
        clientPanel = new JPanel();
        supplierPanel = new JPanel();
        retailShopPanel = new JPanel();
        wholesaleStorePanel = new JPanel();
              
        clientPanel.setVisible(false);
        supplierPanel.setVisible(false);
        retailShopPanel.setVisible(false);
        wholesaleStorePanel.setVisible(false);
        
        clientPanel.setPreferredSize(new Dimension(200,800));
        supplierPanel.setPreferredSize(new Dimension(200,800));
        retailShopPanel.setPreferredSize(new Dimension(200,800));
        wholesaleStorePanel.setPreferredSize(new Dimension(200,800));
        
        this.add(clientPanel);
        this.add(supplierPanel);
        this.add(retailShopPanel);
        this.add(wholesaleStorePanel);
        
        iconClientLabel = new JLabel();
        iconSupplierLabel = new JLabel();
        iconRetailShopLabel = new JLabel();
        iconWholesaleStoreLabel = new JLabel();
        
        vaccinatedClientLabel = new JLabel();
        vaccinatedClientLabel.setFont(new Font("Verdana",1,20));
        positionClientLabel = new JLabel();
        positionClientLabel.setFont(new Font("Verdana",1,20));
        numOfProductsClientLabel = new JLabel();
        numOfProductsClientLabel.setFont(new Font("Verdana",1,15));
        firstNameLabel = new JLabel();
        firstNameLabel.setFont(new Font("Verdana",1,20));
        lastNameLabel = new JLabel();
        lastNameLabel.setFont(new Font("Verdana",1,20));
        SSNLabel = new JLabel();
        SSNLabel.setFont(new Font("Verdana",1,20));
        nextShopLabel = new JLabel();
        nextShopLabel.setFont(new Font("Verdana",1,20));
        
        vaccinatedSupplierLabel = new JLabel();
        vaccinatedSupplierLabel.setFont(new Font("Verdana",1,20));
        positionSupplierLabel = new JLabel();
        positionSupplierLabel.setFont(new Font("Verdana",1,20));
        numOfProductsSupplierLabel = new JLabel();
        numOfProductsSupplierLabel.setFont(new Font("Verdana",1,15));
        IDLabel = new JLabel();
        IDLabel.setFont(new Font("Verdana",1,20));
        companyLabel = new JLabel();
        companyLabel.setFont(new Font("Verdana",1,20));
        carBrandLabel = new JLabel();
        carBrandLabel.setFont(new Font("Verdana",1,20));
        routeLabel = new JLabel();
        routeLabel.setFont(new Font("Verdana",1,20)); 
        
    
        clientsNowLabel = new JLabel();
        clientsNowLabel.setFont(new Font("Verdana",1,20));
        lockdownLabel = new JLabel();
        lockdownLabel.setFont(new Font("Verdana",1,20));
        peopleCapacityRetailLabel = new JLabel();
        peopleCapacityRetailLabel.setFont(new Font("Verdana",1,20));
        storageCapacityRetailLabel = new JLabel();
        storageCapacityRetailLabel.setFont(new Font("Verdana",1,20));
        addressRetailLabel = new JLabel();
        addressRetailLabel.setFont(new Font("Verdana",1,14));
        supplySizeRetailLabel = new JLabel();
        supplySizeRetailLabel.setFont(new Font("Verdana",1,15));
        
        
        stopClientButton = new JButton();
        stopClientButton.setText("DELETE");
        stopClientButton.setFont(new Font("Arial", Font.PLAIN, 40));
        stopSupplierButton = new JButton();
        stopSupplierButton.setText("DELETE");
        stopSupplierButton.setFont(new Font("Arial", Font.PLAIN, 40));
        
        routeField = new JTextField();
        //routeField.w

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
                
    }
    
    
    public void refreshClient(ClientThread clientThread, HashMap<String, ImageIcon>images){
        Client client = clientThread.getClient();
        currentPanel.setVisible(false);
        currentPanel = clientPanel;
        currentPanel.setVisible(true);
                
        if(client.getMask() == true){
            if(client.getSick() == true){
                ImageIcon icon = new ImageIcon(images.get("sickMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            } else{
                ImageIcon icon = new ImageIcon(images.get("healthyMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            }
        } else {
            if(client.getSick() == true){
                ImageIcon icon = new ImageIcon(images.get("sickImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            } else {
                ImageIcon icon = new ImageIcon(images.get("healthyImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconClientLabel.setIcon(icon);
            }
        }
        
        vaccinatedClientLabel.setText("Vaccinated: " + Boolean.toString(client.getVaccinated()));
        positionClientLabel.setText("X: " + Integer.toString(client.getPosition().getX()) + " Y: " + Integer.toString(client.getPosition().getY()));
        numOfProductsClientLabel.setText("Number of products: " + Integer.toString(client.getCart().size()));
        firstNameLabel.setText("First name: " + client.getFirstName());
        lastNameLabel.setText("Last name: " + client.getLastName());
        SSNLabel.setText("SSN: " + client.getSSN());
        nextShopLabel.setText("Next shop: " + client.getNextShop());
        
        stopClientButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientThread.stop();
                clientThread.getIcon().setVisible(false);
                client.resetPosition();
                if(client.getAtIntersection()){
                    client.getCurrentIntersection().setAvailable(true);
                }
                
            }
        });
    }
    
    public void refreshSupplier(SupplierThread supplierThread, HashMap<String, ImageIcon>images) {
        Supplier supplier = supplierThread.getSupplier();
        currentPanel.setVisible(false);
        currentPanel = supplierPanel;
        currentPanel.setVisible(true);
        
        if (supplier.getCar().getBrand().equals("ferrari")){
            ImageIcon icon = new ImageIcon(images.get("ferrariRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        } else if (supplier.getCar().getBrand().equals("golf")){
            ImageIcon icon = new ImageIcon(images.get("golfRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        } else {
            ImageIcon icon = new ImageIcon(images.get("carRightImage").getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT));
            iconSupplierLabel.setIcon(icon);
        }

        
        vaccinatedSupplierLabel.setText("Vaccinated: " + Boolean.toString(supplier.getVaccinated()));
        positionSupplierLabel.setText("X: " + Integer.toString(supplier.getPosition().getX()) + " Y: " + Integer.toString(supplier.getPosition().getY()));
        numOfProductsSupplierLabel.setText("Number of products: " + Integer.toString(supplier.getTrunk().size()));
        IDLabel.setText("ID: " + Integer.toString(supplier.getID()));
        companyLabel.setText("Company: " + supplier.getCompany());
        carBrandLabel.setText("Car brand: " + supplier.getCar().getBrand());
        routeLabel.setText("Route: " + supplier.getRoute());
        
        
        routeField.setText(supplier.getRoute().toString().substring(1, supplier.getRoute().toString().length()-1));
        
        routeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = routeField.getText();
                String[] inputs = input.split(", ");
                ArrayList<Integer> newRoute = new ArrayList<Integer>();
                     
                for(int i = 0; i < inputs.length; i++){
                    newRoute.add(Integer.parseInt(inputs[i]));
                }
                //System.out.println(newRoute);
                supplier.setRoute(newRoute);
                
            }
        });
        
        stopSupplierButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                supplierThread.stop();
                supplierThread.getIcon().setVisible(false);
                supplier.resetPosition();
                if(supplier.getAtIntersection()){
                    supplier.getCurrentIntersection().setAvailable(true);
                }
            }
        });

    }
    
    public void refreshRetailShop(RetailShopThread retailShopThread, HashMap<String, ImageIcon>images) {
        RetailShop retailShop = retailShopThread.getRetailShop();
        currentPanel.setVisible(false);
        currentPanel = retailShopPanel;
        currentPanel.setVisible(true);
        
        ImageIcon icon = new ImageIcon(images.get("retailShopImage").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT));
        iconRetailShopLabel.setIcon(icon);
        
        clientsNowLabel.setText("Clients in shop: " + Integer.toString(retailShop.getClientsNow()));
        lockdownLabel.setText("Lockdown: " + Boolean.toString(retailShop.getLockdown()));
        peopleCapacityRetailLabel.setText("Max people: " + Integer.toString(retailShop.getClientCapacity()));
        storageCapacityRetailLabel.setText("Storage capacity: " + Integer.toString(retailShop.getStorageCapacity()));
        addressRetailLabel.setText("Address: " + retailShop.getAddress());
        supplySizeRetailLabel.setText("num of products: " + Integer.toString(retailShop.getCurrentSupply().size()));
        
    }
    
    public void refreshWholesaleStore(WholesaleStoreThread wholesaleStoreThread, HashMap<String, ImageIcon>images) {
        WholesaleStore wholesaleStore = wholesaleStoreThread.getWholesaleStore();
        currentPanel.setVisible(false);
        currentPanel = wholesaleStorePanel;
        currentPanel.setVisible(true);
        
        ImageIcon icon = new ImageIcon(images.get("wholesaleStoreImage").getImage().getScaledInstance(200, 190, Image.SCALE_DEFAULT));
        iconWholesaleStoreLabel.setIcon(icon);
        
        
    }
}

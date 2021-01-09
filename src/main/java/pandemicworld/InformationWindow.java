
package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class InformationWindow extends JPanel {
    
    private JPanel currentPanel;
    private JPanel clientPanel;
    private JPanel supplierPanel;
    private JPanel retailShopPanel;
    private JPanel wholesaleStorePanel;
    
    private JLabel iconLabel;
    
    private JLabel vaccinatedLabel;
    private JLabel positionLabel;
    private JLabel numOfProductsLabel;
    
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel SSNLabel;
    private JLabel nextShopLabel;
    
    public InformationWindow() {

        setBackground(Color.BLUE);
        setFocusable(true);

        currentPanel = new JPanel();
        clientPanel = new JPanel();
        supplierPanel = new JPanel();
        retailShopPanel = new JPanel();
        wholesaleStorePanel = new JPanel();
              
        clientPanel.setVisible(true);
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
        
        iconLabel = new JLabel();
        
        vaccinatedLabel = new JLabel();
        vaccinatedLabel.setFont(new Font("Verdana",1,20));
        positionLabel = new JLabel();
        positionLabel.setFont(new Font("Verdana",1,20));
        numOfProductsLabel = new JLabel();
        numOfProductsLabel.setFont(new Font("Verdana",1,15));
        
        firstNameLabel = new JLabel();
        firstNameLabel.setFont(new Font("Verdana",1,20));
        lastNameLabel = new JLabel();
        lastNameLabel.setFont(new Font("Verdana",1,20));
        SSNLabel = new JLabel();
        SSNLabel.setFont(new Font("Verdana",1,20));
        nextShopLabel = new JLabel();
        nextShopLabel.setFont(new Font("Verdana",1,20));
        
        //vaccinatedLabel.setFont(new Font("Verdana",1,20));
        //vaccinatedLabel.setText("dqwdqwd");
        clientPanel.add(iconLabel);
        clientPanel.add(vaccinatedLabel);
        clientPanel.add(positionLabel);
        clientPanel.add(numOfProductsLabel);
        clientPanel.add(firstNameLabel);
        clientPanel.add(lastNameLabel);
        clientPanel.add(SSNLabel);
        clientPanel.add(nextShopLabel);
                
    }
    
    
    public void refreshClient(Client client, HashMap<String, ImageIcon>images){
        currentPanel.setVisible(false);
        currentPanel = clientPanel;
        currentPanel.setVisible(true);
        
        boolean mask = client.getVaccinated();
        
        if(client.getMask() == true){
            if(client.getSick() == true){
                ImageIcon icon = new ImageIcon(images.get("sickMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconLabel.setIcon(icon);
            } else{
                ImageIcon icon = new ImageIcon(images.get("healthyMaskImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconLabel.setIcon(icon);
            }
        } else {
            if(client.getSick() == true){
                ImageIcon icon = new ImageIcon(images.get("sickImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconLabel.setIcon(icon);
            } else {
                ImageIcon icon = new ImageIcon(images.get("healthyImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                iconLabel.setIcon(icon);
            }
        }
        
        //ImageIcon icon = new ImageIcon(images.get("sickImage").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        //iconLabel.setIcon(icon);
        //iconLabel.setText("Vaccinated:");
             
        vaccinatedLabel.setText("Vaccinated: " + Boolean.toString(client.getVaccinated()));
        positionLabel.setText("X: " + Integer.toString(client.getPosition().getX()) + " Y: " + Integer.toString(client.getPosition().getY()));
        numOfProductsLabel.setText("Number of products: " + Integer.toString(client.getCart().size()));
        firstNameLabel.setText("First name: " + client.getFirstName());
        lastNameLabel.setText("Last name: " + client.getLastName());
        SSNLabel.setText("SSN: " + client.getSSN());
        nextShopLabel.setText("Next shop: " + client.getNextShop());

        
        System.out.println(client.getPosition().getY());
       // jlabel.setVisible(false);
    }
    
}

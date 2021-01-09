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
import java.util.concurrent.ThreadLocalRandom;
//import java.util.HashMap;

public class App extends JFrame{

    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Pandemic world!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
                
        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      //  container.set

        InformationWindow informationWindow = new InformationWindow();
        informationWindow.setPreferredSize(new Dimension(200,800));
        
        Map map = new Map(informationWindow);
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


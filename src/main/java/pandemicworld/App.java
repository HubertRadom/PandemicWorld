package pandemicworld;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import static java.lang.Thread.sleep;

public class App extends JFrame{
    public static void main(String[] args) throws InterruptedException, IOException {
        JFrame frame = new JFrame("Pandemic world!");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
                
    JPanel container = new JPanel();
    //container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    //container.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));

    //panel1.set[Preferred/Maximum/Minimum]Size()
        
        
        Map map = new Map();
        map.setPreferredSize(new Dimension(1600,800));
        //map.setSize(300,300);
        //map.setBounds(100, 100, 100, 100);
       // map.setBounds(0, 0, 300, 300);
       // frame.getContentPane().add(map);
        
        //Test test = new Test();
       // frame.getContentPane().add(test);
       
      
      // informationWindow.setBounds(100,0,100,100);
        
        JButton myButton = new JButton("My Button");
       
        JLabel jlabel = new JLabel("This is a label");
        jlabel.setFont(new Font("Verdana",1,20));
      // jlabel.setSize(1,1)
        jlabel.setText("dqwdqwd");
      //System.out.println(jlabel.getClass());
        
        InformationWindow informationWindow = new InformationWindow(jlabel);
      
        container.add(map);
        //container.add(test);
        container.add(informationWindow);
        container.add(myButton);
        container.add(jlabel);
        
        frame.getContentPane().add(container);

        //frame.getContentPane().add(new Passenger(10));
       // frame.getContentPane().add(new Passenger(50));
       // frame.add(new Passenger(50))
        frame.setPreferredSize(new Dimension(1800,850));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        //System.out.println("main");
        /*
        for(int i = 0; i<5; i++){
            
            for(int j = 0; j<5; j++){
                if(j==3){
                    break;
                }
                System.out.println(i);
                System.out.println(j);
                
            }
        } */
        
      // map.ballComponentList.get(0).right();
      // sleep(2000);
      // System.out.println("sleep");
     //  map.ballComponentList.get(0).right();
       // System.out.println(frame.getContentPane());
       // System.out.println(frame.getComponent(1));
        //frame.Ball
    }
}


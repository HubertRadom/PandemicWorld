
package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Test extends JPanel {

    public ArrayList<BallComponent> ballComponentList;



    public Test() {
        ballComponentList = new ArrayList<>();
        setBackground(Color.BLUE);
        setFocusable(true);
        CubbyHole c = new CubbyHole();

        BallComponent p1 = new BallComponent(250, 100, 50, c);
        BallComponent p2 = new BallComponent(250, 150, 50, c);
        BallComponent p3 = new BallComponent(250, 200, 50, c);
        BallComponent p4 = new BallComponent(250, 250, 50, c);


        p1.start();
        p2.start();
        ballComponentList.add(p1);
        ballComponentList.add(p2);
        p3.start();
        p4.start();
        ballComponentList.add(p3);
        ballComponentList.add(p4);
        
       // map.ballComponentList.get(0).right();
        //ballComponentList.add(new BallComponent(350, 150, 60));
        repaint();
        //ballComponentList.add(new BallComponent(350, 250, 60));
        //timer = new Timer(new bListener());

        //while(true){
        //ballComponentList.get(0).updatePosition();
        //}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(BallComponent b: ballComponentList){
            if(b.x-(b.size/2)<0 || b.x+(b.size/2)>getWidth()){
                g.fillOval(b.x-(b.size/2), b.y-(b.size/2), (int)(b.size/1.3), b.size);
                //System.out.println("test1");
            }
            else if(b.y-(b.size/2)<0 || b.y+(b.size/2)>getHeight()){
                g.fillOval(b.x-(b.size/2), b.y-(b.size/2), b.size, (int)(b.size/1.3));
                //System.out.println("test2");
            }
            else{
                g.fillOval(b.x-(b.size/2), b.y-(b.size/2), b.size, b.size);
                //System.out.println("test");
            }
            g.setColor(b.color);
        }
    }
/*
       private class bListener implements  //MouseListener,
                                        ActionListener,
                                       // MouseMotionListener,
                                      //  MouseWheelListener,
                                       // KeyListener
    {
           


        @Override
        public void actionPerformed(ActionEvent e) {
            for(BallComponent k: ballComponentList){
                k.updatePosition();
            }
            repaint();
        } }
*/
    public class BallComponent extends Thread {
        private Color color;
        public int x;
        public int y;
        public int size;
        private final int MAXSPEED = 5;
        public int xspeed;
        public int yspeed;
        private CubbyHole cubbyhole;


        public BallComponent(int x, int y, int size, CubbyHole c) {
            cubbyhole = c;
            this.x = x;
            this.y = y;
            this.size = size;
            xspeed = (int)(Math.random()* MAXSPEED *2 - MAXSPEED);
            yspeed = (int)(Math.random()* MAXSPEED *2 - MAXSPEED);
            if(xspeed == 0 && yspeed == 0){
                xspeed = 1;
                yspeed = 1;
            }
            setRandomColor();
        }
        
        public void right(){
            x+=2;
            repaint();
        }

        public void updatePosition(){
            x+=xspeed;
            y+=yspeed;

            if(x-(size/2)<0 || x+(size/2)>getWidth()){
                xspeed = -xspeed;
            }
            if(y-(size/2)<0 || y+(size/2)>getHeight()){
                yspeed = -yspeed;
            }

        }

        public void setRandomColor(){
            Random rand = new Random();

            color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        }
        public void run(){
            while(true){
                try {
                    sleep(300);
                    right();
                    if(x==160){
                        
                        try {
                             sleep(2000);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        System.out.println(cubbyhole.peop);
                        cubbyhole.go();
                     
                         System.out.println(cubbyhole.peop);
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
   class CubbyHole {
   //private int contents;
   private boolean stuck = false;
   private int peop = 0;
   
   public synchronized void go() {
      while (stuck == true) {
         try {
            wait();
         } catch (InterruptedException e) {}
      }
      if (peop>2){
          stuck=true;
      } else {
      stuck = false;
      }
      
      notifyAll();
   }
}
}

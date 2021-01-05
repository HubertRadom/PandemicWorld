
package pandemicworld;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Map extends JPanel {

    public ArrayList<Client> clientList;
    public ArrayList<RetailShop> retailShopList;
    private ArrayList<ArrayList> adjacency;
    private ArrayList<Street> sidewalkList;
    private Image backgroundImage;
    private Image humanImage;



    public Map() throws IOException {
        clientList = new ArrayList<>();
        retailShopList = new ArrayList<>();
        adjacency = new ArrayList<>();
        sidewalkList = new ArrayList<>();

        backgroundImage = ImageIO.read(new File("images/mapanew.png"));
        humanImage = ImageIO.read(new File("images/healthy.png"));
        setFocusable(true);



        RetailShop shop0 = new RetailShop(new Position(700,200),"d","c",1,2);
        RetailShop shop1 = new RetailShop(new Position(330,100),"d","c",1,2);
        RetailShop shop2 = new RetailShop(new Position(100,300),"d","c",1,2);
        RetailShop shop3 = new RetailShop(new Position(330,500),"d","c",1,2);
        RetailShop shop4 = new RetailShop(new Position(100,500),"d","c",1,2);
        retailShopList.add(shop0);
        retailShopList.add(shop1);
        retailShopList.add(shop2);
        retailShopList.add(shop3);
        retailShopList.add(shop4);
        
        Intersection intersection1 = new Intersection(new Position(330,300));
        
/*
        Street street1 = new Street("0 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(700,200),new Position(700,300),new Position(330,300),new Position(100,300))));
        
        Street street2 = new Street("2 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,300), new Position(330,300), new Position(700,300), new Position(700,200))));
        
        Street street5 = new Street("4 3", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,500), new Position(330,500))));
        
        Street street6 = new Street("3 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(330,500), new Position(330,300), new Position(700,300), new Position(700,200))));
                
        Street street7 = new Street("4 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,500), new Position(100,300))));
 */       

        //connection with main intersection
        //SIDEWALK
        sidewalkList.add(new Street("0 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(700,200),new Position(700,300),new Position(330,300),new Position(100,300)))));
        sidewalkList.add(new Street("x 0", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,300), new Position(330,300), new Position(700,300), new Position(700,200)))));
        sidewalkList.add(new Street("1 x", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,500), new Position(330,500)))));
        sidewalkList.add(new Street("x 1", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(330,500), new Position(330,300), new Position(700,300), new Position(700,200)))));
        sidewalkList.add(new Street("4 2", new ArrayList(Arrays.asList(intersection1)), new ArrayList(Arrays.asList(
            new Position(100,500), new Position(100,300)))));

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


        
        
        Client client1 = new Client(false,false,false,new Position(100,300),"a","a","a",1);
        clientList.add(client1);
        ClientThread c1 = new ClientThread(client1,adjacency,sidewalkList,2,0);
        c1.start();
        
        Client client2 = new Client(false,false,false,new Position(100,500),"a","a","a",1);
        clientList.add(client2);
        ClientThread c2 = new ClientThread(client2,adjacency,sidewalkList,4,0);
        c2.start();
        
        Paint paint = new Paint();
        paint.start();        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, this);

            
        for(Client c: clientList){
            //g.fillOval(c.getPosition().getX()-(50/2), c.getPosition().getY()-(50/2), 50, 50);
            g.drawImage(humanImage, c.getPosition().getX()-(32/2), c.getPosition().getY()-(32/2), this);
        }
        
         g.setColor(new Color(255,255,255));
        for(RetailShop c: retailShopList){
            g.fillOval(c.getPosition().getX()-(25/2), c.getPosition().getY()-(25/2), 25, 25);
        }
        
        
    }
    public class Paint extends Thread {
        @Override
        public void run(){
            while(true){
                sleep(20);
                repaint();
            }
        }
    }
    public class ClientThread extends Thread {
        private Client client;
        private  ArrayList<ArrayList>adjacency;
        private  ArrayList<Street>sidewalkList;
        private int from, to;
        private Street currentSidewalk;
        //private Street nextStreet;
        private int next;
        
        
        public ClientThread(Client c, ArrayList<ArrayList>a,  ArrayList<Street>s, int start, int end) {
            client = c;
            adjacency = a;
            sidewalkList = s;
            from = start;
            to = end;
        }
        
        @Override
        public void run() {
            while(true){
                
                if(adjacency.get(from).get(to).equals(1)){
                    for(int i = 0; i < sidewalkList.size(); i++){
                        if(sidewalkList.get(i).getFromTo().equals(Integer.toString(from)+ " " + Integer.toString(to))){
                            currentSidewalk = sidewalkList.get(i);
                        }
                    }       
                }
                else{
                    
                    for(int i = 0; i < retailShopList.size(); i++){
                        if(adjacency.get(from).get(i).equals(1) && adjacency.get(i).get(to).equals(1)){
                            System.out.println(Integer.toString(from)+Integer.toString(i));
                            for(int j = 0; j < sidewalkList.size(); j++){
                                if(sidewalkList.get(j).getFromTo().equals(Integer.toString(from)+Integer.toString(i))){
                                    currentSidewalk = sidewalkList.get(j);
                                }
                                if(sidewalkList.get(j).getFromTo().equals(Integer.toString(i)+Integer.toString(to))){
                                    next = i;
                                }
                            }
                        from = next;
                        break;
                        }
                        
                    }
                }
                
                for(int j = 0; j < currentSidewalk.getTurns().size(); j++){
                    while(client.getPosition().getX() < currentSidewalk.getTurns().get(j).getX()){

                            client.move("right");
                            sleep(10);
                            //repaint();

                    }

                    while(client.getPosition().getX() > currentSidewalk.getTurns().get(j).getX()){

                            client.move("left");
                            sleep(10);
                            //repaint();

                    }

                    while(client.getPosition().getY() < currentSidewalk.getTurns().get(j).getY()){

                            client.move("down");
                            sleep(10);
                            //repaint();

                    }

                    while(client.getPosition().getY() > currentSidewalk.getTurns().get(j).getY()){

                            client.move("up");
                            sleep(10);
                            //repaint();

                    }
                    //intersection
                    for(Intersection inter: currentSidewalk.getIntersections()){
                        if(inter.getPosition().getX() == client.getPosition().getX() &&
                                inter.getPosition().getY() == client.getPosition().getY()){
                            System.out.println("intersection");
                            sleep(1500);
                        }
                        //System.out.println(inter.getPosition().getX());
                    }
                }
                     
            }
        }
    }
/*
       private class bListener implements  //MouseListener,
                                        ActionListener,
                                       // MouseMotionListener,
                                      //  MouseWheelListener,
                                       // KeyListener
    {

*/

}

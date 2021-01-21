package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.List;

public class Intersection {
    //private Position position;
    private Position downLeftCorner;
    private Position upRightCorner;
    private boolean available = true;
    
    Intersection(Position dl, Position ur) {
       // position = p;
        downLeftCorner = dl;
        upRightCorner = ur;
    }
    
    public Position getDL(){
        return downLeftCorner;
    }
    //public Position getPosition(){
    //    return position;
    //}
    public boolean atIntersection(Position pos){
        if(pos.getX() <  downLeftCorner.getX() || pos.getX() >  upRightCorner.getX()){
            return false;
        }
        if(pos.getY() >  downLeftCorner.getY() || pos.getY() <  upRightCorner.getY()){
            return false;
        }
        return true;
    }
    
    public synchronized void enter() {
        while (available == false) {
           try {
              wait();
              
           } catch (InterruptedException e) {}
        }
        //System.out.println("enter");
        //sleep(1000);
        
        available = false;
        notifyAll();
    }
    public synchronized void leave() {
      //while (available == true) {
      //   try {
       ///     wait();
            
      //   } catch (InterruptedException e) { } 
     // }
      
      //System.out.println("leave");
      //System.out.println("leave");
      available = true;
      //System.out.println(available);
      notifyAll();
   }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
    public boolean getAvailable(){
        return available;
    }
}

package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;

public class Person implements Path {
    private boolean sick;
    private boolean mask;
    private boolean vaccinated;
    private Position position;
    private List<Position>path;
    private List<Position>route;
    private String direction = "right";
    
    Person(boolean s, boolean m, boolean v, Position cp) {
        sick = s;
        mask = m;
        vaccinated = v;
        position = cp;
    }
    
    
    public void infect() {
        
    }

    public void getPath(int from, int to, ArrayList<ArrayList>adjacency) {
        
    }
    public void draw(){
        
    }
    public Position getPosition(){
        return position;
    }
    
    public boolean getMask(){
        return mask;
    }
    
    public boolean getSick(){
        return sick;
    }
    
    public boolean getVaccinated(){
        return vaccinated;
    }
    
    public String getDirection(){
        return direction;
    }
    
    public void move(String direction){
        if(direction.equals("up")){
            position.setY(position.getY()-1);
        } else if (direction.equals("down")){
            position.setY(position.getY()+1);
        } else if (direction.equals("right")){
            position.setX(position.getX()+1);
        } else if (direction.equals("left")){
            position.setX(position.getX()-1);
        }
    }
    

    
    public void travel(Street street){
        for(int j = 0; j < street.getTurns().size(); j++){
            while(this.getPosition().getX() < street.getTurns().get(j).getX()){

                    this.move("right");
                    this.direction = "right";
                    sleep(20);
                    //repaint();

            }

            while(this.getPosition().getX() > street.getTurns().get(j).getX()){

                    this.move("left");
                    this.direction = "left";
                    sleep(20);
                    
                    //repaint();

            }

            while(this.getPosition().getY() < street.getTurns().get(j).getY()){

                    this.move("down");
                    this.direction = "down";
                    sleep(20);
                    //repaint();

            }

            while(this.getPosition().getY() > street.getTurns().get(j).getY()){

                    this.move("up");
                    this.direction = "up";
                    sleep(20);
                    //repaint();

            }
        }
    }
}

package pandemicworld;

import java.util.ArrayList;
import java.util.List;

public class Person implements Path, Object{
    private boolean sick;
    private boolean mask;
    private boolean vaccinated;
    private Position position;
    private List<Position>path;
    private List<Position>route;
    
    Person(boolean s, boolean m, boolean v, Position cp) {
        sick = s;
        mask = m;
        vaccinated = v;
        position = cp;
    }
    
    public void infect() {
        
    }
    public void travel() {
        position.setX(position.getX()-1);
    }
    public void getPath(int from, int to, ArrayList<ArrayList>adjacency) {
        
    }
    public void draw(){
        
    }
    public Position getPosition(){
        return position;
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
}

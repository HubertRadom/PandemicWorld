//road or sidewalk

package pandemicworld;

import java.util.List;

public class Street {
    //index of first and second shop for example 15 for shops 1 and 5
    private String fromTo;
    private List<Intersection> intersections;
    private List<Position>turns;
    Street(String ft, List<Intersection> i, List<Position> t){
        fromTo=ft;
        intersections=i;
        turns=t;
    }
    
    public List<Position> getTurns(){
        return turns;
    }
    public String getFromTo(){
        return fromTo;
    }
    public List<Intersection>getIntersections(){
        return intersections;
    }
}

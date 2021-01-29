package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person implements Path {
    private boolean sick;
    private boolean mask;
    private boolean vaccinated;
    private Position position;
    private String direction = "right";
    private Intersection currentIntersection;
    private boolean atInter = false;
    
    
    Person(boolean s, boolean m, boolean v, Position cp) {
        sick = s;
        mask = m;
        vaccinated = v;
        position = cp;
    }
    
    
    public void infect(RetailShop shop, double transRate, double transVacc) {
        for(Person person: shop.getPeople()){
            if(person.getVaccinated()){
                if(Math.random() < transVacc){
                    person.setSick(true);
                }
            } else {
                if(Math.random() < transRate){
                    person.setSick(true);
                }
            }
        }
    }

    public void getPath(int from, int to, ArrayList<ArrayList>adjacency) {
        
    }
    public void draw(){
        
    }
    public Position getPosition(){
        return position;
    }
    
    public void resetPosition(){
        position.setX(0);
        position.setY(0);
    }
    public void setPosition(Position position){
        this.position = position;
    }
    
    public boolean getMask(){
        return mask;
    }
    
    public boolean getSick(){
        return sick;
    }
    public void setSick(boolean s){
        sick = s;
    }
    
    public boolean getVaccinated(){
        return vaccinated;
    }
    
    public String getDirection(){
        return direction;
    }
    
    public Intersection getCurrentIntersection(){
        return currentIntersection;
    }
    public boolean getAtIntersection(){
        return atInter;
    }
    
    public void move(String direction){
        switch(direction){
            case "up":
                position.setY(position.getY()-1);
                break;
            case "down":
                position.setY(position.getY()+1);
                break;
            case "right":
                position.setX(position.getX()+1);
                break;
            case "left":
                position.setX(position.getX()-1);
                break;
        }
    }
    

    
    public void travel(Street street, ArrayList<Person>people, int distance){
        for(int j = 0; j < street.getTurns().size(); j++){
            
            while(this.getPosition().getY() < street.getTurns().get(j).getY()){
               
                    this.move("down");
                    this.direction = "down";
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                //System.out.println(inters.getAvailable());
                                
                                currentIntersection = inters;
                                currentIntersection.enter();
                                //System.out.println(currentIntersection.getAvailable());
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                    
                    //for(Person person: people){
                    for(int p = 0; p < people.size(); p++) {
                        while(position.getX() == people.get(p).getPosition().getX() &&
                                position.getY() < people.get(p).getPosition().getY() &&
                                position.getY()+distance > people.get(p).getPosition().getY()-distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }

            while(this.getPosition().getY() > street.getTurns().get(j).getY()){

                
                    this.move("up");
                    this.direction = "up";
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                   // for(Person person: people){
                    for(int p = 0; p < people.size(); p++) {
                        while(position.getX() == people.get(p).getPosition().getX() &&
                                position.getY() > people.get(p).getPosition().getY() &&
                                position.getY()-distance < people.get(p).getPosition().getY()+distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }
            
            while(this.getPosition().getX() < street.getTurns().get(j).getX()){

                    this.move("right");
                    this.direction = "right";
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                               // atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }

                    
                    //for(Person person: people){
                    for(int p = 0; p < people.size(); p++) {
                        while(position.getY() == people.get(p).getPosition().getY() &&
                                position.getX() < people.get(p).getPosition().getX() &&
                                position.getX()+distance > people.get(p).getPosition().getX()-distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    
                
            }

            while(this.getPosition().getX() > street.getTurns().get(j).getX()){

                    this.move("left");
                    this.direction = "left";
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                   // for(Person person: people){
                    for(int p = 0; p < people.size(); p++) {
                        while(position.getY() == people.get(p).getPosition().getY() &&
                                position.getX() > people.get(p).getPosition().getX() &&
                                position.getX()-distance < people.get(p).getPosition().getX()+distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }

        }
    }
    
    
    public void travel(Street street, ArrayList<Person>people, int distance, Car car){
        for(int j = 0; j < street.getTurns().size(); j++){
            
            while(this.getPosition().getY() < street.getTurns().get(j).getY()){
               
                    this.move("down");
                    this.direction = "down";
                    car.burnGas(1);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                //System.out.println(inters.getAvailable());
                                
                                currentIntersection = inters;
                                currentIntersection.enter();
                                //System.out.println(currentIntersection.getAvailable());
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                    
                    for(Person person: people){
                        while(position.getX() == person.getPosition().getX() &&
                                position.getY() < person.getPosition().getY() &&
                                position.getY()+distance > person.getPosition().getY()-distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }

            while(this.getPosition().getY() > street.getTurns().get(j).getY()){

                
                    this.move("up");
                    this.direction = "up";
                    car.burnGas(1);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                    for(Person person: people){
                        while(position.getX() == person.getPosition().getX() &&
                                position.getY() > person.getPosition().getY() &&
                                position.getY()-distance < person.getPosition().getY()+distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }
            
            while(this.getPosition().getX() < street.getTurns().get(j).getX()){

                    this.move("right");
                    this.direction = "right";
                    car.burnGas(1);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                               // atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }

                    
                    for(Person person: people){
                        while(position.getY() == person.getPosition().getY() &&
                                position.getX() < person.getPosition().getX() &&
                                position.getX()+distance > person.getPosition().getX()-distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    
                
            }

            while(this.getPosition().getX() > street.getTurns().get(j).getX()){

                    this.move("left");
                    this.direction = "left";
                    car.burnGas(1);
                    try {
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(!atInter){
                        for(Intersection inters: street.getIntersections()){
                            if(inters.atIntersection(position)){
                                //atInter = true;
                                currentIntersection = inters;
                                currentIntersection.enter();
                                atInter = true;
                            }
                        }
                    } else if (!currentIntersection.atIntersection(position) && atInter){
                        atInter = false;
                        currentIntersection.leave();
                    }
                    
                    for(Person person: people){
                        while(position.getY() == person.getPosition().getY() &&
                                position.getX() > person.getPosition().getX() &&
                                position.getX()-distance < person.getPosition().getX()+distance){
                            try {
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

            }

        }
    }
}

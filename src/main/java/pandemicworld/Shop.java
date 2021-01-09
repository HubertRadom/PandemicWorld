package pandemicworld;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private String address;
    private int storageCapacity;
    private boolean lockdown;
    private ArrayList<Product>currentSupply = new ArrayList<Product>();
    private Position position;
    
    Shop(Position position, String name, String address, int storageCapacity) {
        this.name = name;
        this.address = address;
        this.storageCapacity = storageCapacity;
        this.position = position;
       // currentSupply = new ArrayList<Product>();
    }
    public ArrayList<Product> getCurrentSupply(){
        return currentSupply;
    }
    
    public void checkDate() {
        
    }
    public void removeProduct(Product product) {
        currentSupply.remove(product);
    }
    public void addProduct(Product product) {
        currentSupply.add(product);
    }
    public void lockdown() {
    
    }
    public void draw() {
        
    }
    
    public Position getPosition(){
        return position;
    }
    


}

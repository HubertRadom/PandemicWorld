package pandemicworld;

import java.util.List;

public class Shop implements Object {
    private String name;
    private String address;
    private int clientCapacity;
    private int storageCapacity;
    private boolean lockdown;
    private List<Product>currentSupply;
    private Position position;
    
    Shop(Position p, String n, String a, int cc, int sc) {
        name = n;
        address = a;
        clientCapacity = cc;
        storageCapacity = sc;
        position = p;
    }
    
    public void checkDate() {
        
    }
    public void removeProduct() {
        
    }
    public void addProduct() {
    
    }
    public void lockdown() {
    
    }
    public void draw() {
        
    }
    public Position getPosition(){
        return position;
    }

}

package pandemicworld;

public class Supplier extends Person{
    private int ID;
    private String company;
    private Car car;
    private int trunkCapacity;
    
    Supplier(boolean s, boolean m, boolean v, Position cp, int i, String com, Car c, int tc) {
        super(s,m,v,cp);
        ID = i;
        company = com;
        car = c;
        trunkCapacity = tc;
                
    }
    
    public void exchangeProducts(Shop shop) {
        
    }
    public void fillTank() {
        
    }
    public void getPath(Position from, Position to, Street road) {
        
    }
    public Car getCar(){
        return car;
    }
}

package pandemicworld;

public class Car {
    private String brand;
    private float gas;
    private float gasBurnRate;
    private int tankCapacity;
    
    Car(String b, float g, float gbr, int tc){
        brand = b;
        gas = g;
        gasBurnRate = gbr;
        tankCapacity = tc;
    }
    
    public String getBrand(){
        return brand;
    }
}

package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Car {
    private String brand;
    private double gas;
    private double gasBurnRate;
    private double tankCapacity;
    
    Car(String b, double g, double gbr, int tc){
        brand = b;
        gas = g;
        gasBurnRate = gbr;
        tankCapacity = tc;
    }
    
    public String getBrand(){
        return brand;
    }
    public double getGas(){
        return gas;
    }
    public void burnGas(int distance){
        gas -= gasBurnRate*distance;
    }
    public void fillTank(){
        while(gas < tankCapacity){
            gas+=1;
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}

package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Car {

    private String brand;
    private double gas;
    private double gasBurnRate;
    private double tankCapacity;

    Car(String brand, double gas, double gasBurnRate, int tankCapacity) {
        this.brand = brand;
        this.gas = gas;
        this.gasBurnRate = gasBurnRate;
        this.tankCapacity = tankCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public double getGas() {
        return gas;
    }

    /**
     * Burning gas with proportional distance traveled.
     *
     * @param distance distance traveled
     */
    public void burnGas(int distance) {
        gas -= gasBurnRate * distance;
    }

    /**
     * Filling tank when on stop.
     */
    public void fillTank() {
        while (gas < tankCapacity) {
            gas += 1;
            try {
                sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

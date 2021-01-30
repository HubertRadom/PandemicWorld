package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

public class Supplier extends Person {

    private int ID;
    private String company;
    private Car car;
    private int trunkCapacity;
    private ArrayList<Product> trunk = new ArrayList<Product>();
    private ArrayList<Integer> route;

    Supplier(boolean s, boolean m, boolean v, Position cp, int i, String com, Car c, int tc, ArrayList<Integer> route) {
        super(s, m, v, cp);
        ID = i;
        company = com;
        car = c;
        trunkCapacity = tc;
        this.route = route;
    }

    public void getPath(Position from, Position to, Street road) {

    }

    public Car getCar() {
        return car;
    }

    public int getID() {
        return ID;
    }

    public String getCompany() {
        return company;
    }

    public ArrayList<Integer> getRoute() {
        return route;
    }

    public void setRoute(ArrayList<Integer> newroute) {
        route = newroute;
    }

    public ArrayList<Product> getTrunk() {
        return trunk;
    }

    /**
     * Get products from wholesale store.
     *
     */
    public void getProducts(WholesaleStore shop) throws InterruptedException {
        while (trunk.size() < trunkCapacity) {
            Product prod = shop.giveProduct(this);
            if (prod != null) {
                trunk.add(prod);
            } else {
                break;
            }
            sleep(200);
        }
    }

    /**
     * Leave products in shop.
     *
     */
    public void giveProducts(RetailShop shop) throws InterruptedException {
        while (true) {
            if (shop.enter(this)) {
                for (int i = 0; i < (trunkCapacity / (route.size() - 1)); i++) {
                    if (trunk.size() > 0 && shop.getCurrentSupply().size() < shop.getStorageCapacity()) {
                        Product prod = trunk.get(0);
                        trunk.remove(prod);
                        shop.addProduct(prod);
                        sleep(200);
                    }

                }
                shop.leave(this);
                break;
            }
            sleep(200);
        }

    }

}

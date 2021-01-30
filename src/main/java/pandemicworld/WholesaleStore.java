package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

class WholesaleStore extends Shop {

    ArrayList<Product> typesOfProducts = new ArrayList<Product>();

    public WholesaleStore(Position position, String name, String address, int storageCapacity) {
        super(position, name, address, storageCapacity);
    }

    public ArrayList<Product> getTypesOfProducts() {
        return typesOfProducts;
    }

    /**
     * Create new product that later can be produced and taken by supplier.
     */
    public void createProduct(int id, String name, String brand, double price) {
        typesOfProducts.add(new Product(id, name, brand, new Date(), price));
    }

    /**
     * Fills up the warehouse with random products it has to offer.
     */
    public synchronized void createProduce() {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if (typesOfProducts.size() > 0) {
            while (this.getStorageCapacity() > currSupply.size()) {
                Product prod = typesOfProducts.get(ThreadLocalRandom.current().nextInt(0, typesOfProducts.size()));

                Date date = new Date();
                int day = 24 * 3600000;
                currSupply.add(new Product(prod.getID(), prod.getName(), prod.getBrand(),
                        new Date(date.getTime() + day * ThreadLocalRandom.current().nextInt(1, 90)), Math.random()));
                try {
                    sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WholesaleStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Give products to supplier.
     */
    public synchronized Product giveProduct(Supplier sup) {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if (currSupply.size() > 0) {
            Product prodToSell = currSupply.get(0);
            this.removeProduct(prodToSell);
            return prodToSell;
        }
        return null;
    }
}

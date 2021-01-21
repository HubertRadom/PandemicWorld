package pandemicworld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

class WholesaleStore extends Shop {
    ArrayList<Product>typesOfProducts = new ArrayList<Product>();

    public WholesaleStore(Position position, String name, String address, int storageCapacity) {
        super(position, name, address, storageCapacity);
    }
    public synchronized void createProduce() {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        while(this.getStorageCapacity() > currSupply.size()){
            Product prod = typesOfProducts.get(ThreadLocalRandom.current().nextInt(0, typesOfProducts.size()));
            currSupply.add(new Product(prod.getID(),prod.getName(),prod.getBrand(),"2000.01.01"));
        }
    }
    
    public synchronized Product giveProduct(Supplier sup){
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if(currSupply.size()>0){
            Product prodToSell = currSupply.get(0);
            this.removeProduct(prodToSell);
            return prodToSell;
        }
        return null;
    }
}

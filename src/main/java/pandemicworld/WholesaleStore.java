package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

class WholesaleStore extends Shop {
    ArrayList<Product>typesOfProducts = new ArrayList<Product>();

    public WholesaleStore(Position position, String name, String address, int storageCapacity) {
        super(position, name, address, storageCapacity);
    }
    
    public ArrayList<Product> getTypesOfProducts(){
        return typesOfProducts;
    }
    
    public void createProduct(int id, String name, String brand, String date){
        typesOfProducts.add(new Product(id, name, brand, date));
    }
    
    public synchronized void createProduce() {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if(typesOfProducts.size()>0) {
            while(this.getStorageCapacity() > currSupply.size()){
                Product prod = typesOfProducts.get(ThreadLocalRandom.current().nextInt(0, typesOfProducts.size()));
                currSupply.add(new Product(prod.getID(),prod.getName(),prod.getBrand(), prod.getBeforeDate()));
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WholesaleStore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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

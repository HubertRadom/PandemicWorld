package pandemicworld;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WholesaleStoreThread extends Thread {
    private WholesaleStore shop;
    
    WholesaleStoreThread(WholesaleStore shop){
        this.shop = shop;
    }
    
    public WholesaleStore getWholesaleStore(){
        return shop;
    }
    
    @Override
    public void run(){
        while(true){
            shop.createProduce();
            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WholesaleStoreThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

package pandemicworld;

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
        
    }
}

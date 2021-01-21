package pandemicworld;

public class RetailShopThread extends Thread {
    private RetailShop shop;
    
    RetailShopThread(RetailShop shop){
        this.shop = shop;
    }
    
    public RetailShop getRetailShop(){
        return shop;
    }
    
    @Override
    public void run(){
        
    }
}

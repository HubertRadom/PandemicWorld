package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Client extends Person {
    private String firstName;
    private String lastName;
    private String SSN;
    private int cartCapacity;
    //private Shop nextShop;
    private int nextShop;
    private ArrayList<Product>cart = new ArrayList<Product>();

    public Client(boolean s, boolean m, boolean v, Position cp, String fn, String ln, String ssn, int cc) {
        super(s, m, v, cp);
        firstName = fn;
        lastName = ln;
        SSN = ssn;
        cartCapacity = cc;
    }
    
    public ArrayList<Product> getCart(){
        return cart;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSSN(){
        return SSN;
    }
    public int getNextShop(){
        return nextShop;
    }
    
    public int nextShop() {
        nextShop = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        return nextShop;
    }
    public void buy(RetailShop shop, int numOfProducts) throws InterruptedException {
        //how many products buy in range (0,10)
        int n = ThreadLocalRandom.current().nextInt(1, numOfProducts + 1);

        while(true){
            if(shop.enter(this)){

               for(int i = 0; i < n; i++){
                   Product prod = shop.sellProduct(this);
                   if(prod!=null){
                       cart.add(prod);
                   }
                   sleep(1000);
               }
               
               shop.leave(this);
               break;
            }
            sleep(50);
        }
        

    }
    public void consume() {
        
    }
    


}

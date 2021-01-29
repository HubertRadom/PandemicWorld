package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RetailShop extends Shop {
    
        private int clientCapacity;
        private int lockdownClientCapacity;
        private int normalClientCapacity;
        private int clientsNow = 0;
        private boolean lockdown;
        //private ArrayList<Client>people = new ArrayList<Client>();
        private List<Person> people = Collections.synchronizedList(new ArrayList<Person>());
        //List<String> syncCollection = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
        
    public RetailShop(Position p, String n, String a, int sc, int cc) {
        super(p, n, a, sc);
        clientCapacity = cc;
        normalClientCapacity = clientCapacity;
        lockdownClientCapacity = clientCapacity / 4;
    }
    
    public List<Person> getPeople(){
        return people;
    }
    public int getClientsNow(){
        return clientsNow;
    }
    public int getClientCapacity(){
        return clientCapacity;
    }
    public boolean getLockdown(){
        return lockdown;
    }
    public void setLockdown(boolean l){
        lockdown = l;
        if(lockdown){
            clientCapacity = lockdownClientCapacity;
        }else{
            clientCapacity = normalClientCapacity;
        }
    }
    public synchronized boolean enter(Person cli) {
        if (clientsNow < clientCapacity){
            clientsNow++; 
            people.add(cli);

            return true;
        }
           return false;
    }
    
    public synchronized void leave(Person cli) {
        clientsNow--;
        people.remove(cli);
    }

    public synchronized Product sellProduct(Client cli){
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if(currSupply.size()>0){
            Collections.shuffle(currSupply);
            Product prodToSell = currSupply.get(0);
            this.removeProduct(prodToSell);
            return prodToSell;
        }
        return null;
        
    }
    
    public void updateInfo(){
       
    }
}

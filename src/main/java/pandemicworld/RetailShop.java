package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RetailShop extends Shop {
    
        private int clientCapacity;
        private int clientsNow = 0;
        //private ArrayList<Client>people = new ArrayList<Client>();
        private List<Client> people = Collections.synchronizedList(new ArrayList<Client>());
        //List<String> syncCollection = Collections.synchronizedList(Arrays.asList("a", "b", "c"));
        
    public RetailShop(Position p, String n, String a, int sc, int cc) {
        super(p, n, a, sc);
        clientCapacity = cc;
    }
    
    public List<Client> getPeople(){
        return people;
    }
    public int getClientsNow(){
        return clientsNow;
    }
    public int getClientCapacity(){
        return clientCapacity;
    }

    public synchronized boolean enter(Client cli) {
        if (clientsNow < clientCapacity){
            clientsNow++; 
            people.add(cli);
            //System.out.println(people);            
            return true;
        }
           return false;
    }
    
    public synchronized void leave(Client cli) {
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

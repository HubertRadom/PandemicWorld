package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class RetailShop extends Shop {

    private int clientCapacity;
    private int lockdownClientCapacity;
    private int normalClientCapacity;
    private int clientsNow = 0;
    private boolean lockdown;
    private List<Person> people = Collections.synchronizedList(new ArrayList<Person>());

    public RetailShop(Position p, String n, String a, int sc, int cc) {
        super(p, n, a, sc);
        clientCapacity = cc;
        normalClientCapacity = clientCapacity;
        lockdownClientCapacity = clientCapacity / 4;
    }

    public List<Person> getPeople() {
        return people;
    }

    public int getClientsNow() {
        return clientsNow;
    }

    public int getClientCapacity() {
        return clientCapacity;
    }

    public boolean getLockdown() {
        return lockdown;
    }

    public void setLockdown(boolean l) {
        lockdown = l;
        if (lockdown) {
            clientCapacity = lockdownClientCapacity;
        } else {
            clientCapacity = normalClientCapacity;
        }
    }

    /**
     * Check if there is room for another person to enter the shop.
     *
     *
     */
    public synchronized boolean enter(Person per) {
        if (clientsNow < clientCapacity) {
            clientsNow++;
            people.add(per);

            return true;
        }
        return false;
    }

    /**
     * Free up space for another person.
     *
     */
    public synchronized void leave(Person cli) {
        clientsNow--;
        people.remove(cli);
    }

    /**
     * If the store is equipped, it returns a random product.
     *
     */
    public synchronized Product sellProduct(Client cli) {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        if (currSupply.size() > 0) {
            Collections.shuffle(currSupply);
            Product prodToSell = currSupply.get(0);
            this.removeProduct(prodToSell);
            return prodToSell;
        }
        return null;

    }

    /**
     * When products use-by date will pass in five days offer discount for this
     * product. When use-by date has already expired remove product.
     */
    public void checkDates() {
        ArrayList<Product> currSupply = this.getCurrentSupply();
        Date date = new Date();
        int day = 24 * 3600000;
        for (Product product : currSupply) {
            if (product.getBeforeDate().getTime() < date.getTime() + day * 5 && !product.getOnSale()) {
                product.setPrice(product.getPrice() / 2);
                product.onSale();
            } else if (product.getBeforeDate().getTime() < date.getTime()) {
                currSupply.remove(product);
            }
        }
    }
}

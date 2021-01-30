package pandemicworld;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;

public class Client extends Person {

    private String firstName;
    private String lastName;
    private String SSN;
    private int cartCapacity;
    private int nextShop;
    private ArrayList<Product> cart = new ArrayList<Product>();

    public Client(boolean s, boolean m, boolean v, Position cp, String firstName, String lastName, String SSN, int cartCapacity) {
        super(s, m, v, cp);
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
        this.cartCapacity = cartCapacity;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return SSN;
    }

    public int getNextShop() {
        return nextShop;
    }

    public int nextShop() {
        nextShop = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        return nextShop;
    }

    /**
     * When shop is free enters shop. Checks availability every 0.2s. Tries to
     * buy n products.
     *
     * @param shop shop in which shopping is made
     * @param icon JLabel of client
     * @param n number of products to buy from range 1 to capacity of cart
     * @throws InterruptedException
     */
    public void buy(RetailShop shop, JLabel icon) throws InterruptedException {
        //how many products buy in range (0,10)
        int n = ThreadLocalRandom.current().nextInt(1, cartCapacity + 1);

        while (true) {
            if (shop.enter(this)) {
                this.setInShop(true);
                icon.setVisible(false);
                this.resetPosition();

                for (int i = 0; i < n; i++) {
                    Product prod = shop.sellProduct(this);
                    if (prod != null) {
                        cart.add(prod);
                    }
                    sleep(3000);
                }

                shop.leave(this);
                this.getPosition().setX(shop.getExit().getX());
                this.getPosition().setY(shop.getExit().getY());
                icon.setVisible(true);
                this.setInShop(false);
                break;
            }
            sleep(200);
        }

    }

    /**
     * If clients buy too many products, consume them.
     */
    public void consume() {
        if (cart.size() > cartCapacity) {
            int n = ThreadLocalRandom.current().nextInt(cart.size() - cartCapacity, cart.size());
            for (int i = 0; i < n; i++) {
                cart.remove(0);
            }
        }
    }
}

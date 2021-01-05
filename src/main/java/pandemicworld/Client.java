package pandemicworld;

import java.util.List;

public class Client extends Person {
    private String firstName;
    private String lastName;
    private String SSN;
    private int cartCapacity;
    private Shop nextShop;

    public Client(boolean s, boolean m, boolean v, Position cp, String fn, String ln, String ssn, int cc) {
        super(s, m, v, cp);
        firstName = fn;
        lastName = ln;
        SSN = ssn;
        cartCapacity = cc;
    }
    
    public void nextShop() {
        
    }
    public void buy() {
        
    }
    public void consume() {
        
    }

}

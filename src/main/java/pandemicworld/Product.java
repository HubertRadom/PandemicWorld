package pandemicworld;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product {
    private int ID;
    private String name;
    private String brand;
    private Date beforeDate;
    
    Product(int i, String n, String b, String dateString) {
        ID = i;
        name = n;
        brand = b;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            beforeDate = sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Date checkDate() {
        return beforeDate;
    }
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getBrand(){
        return brand;
    }
}

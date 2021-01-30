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
    private double price;
    private boolean onSale = false;

    Product(int ID, String name, String brand, String dateString, double price) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        try {
            this.beforeDate = sdf.parse(dateString);
        } catch (ParseException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Product(int ID, String name, String brand, Date date, double price) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.beforeDate = date;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public Date checkDate() {
        return beforeDate;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void onSale() {
        onSale = true;
    }

    public boolean getOnSale() {
        return onSale;
    }

    public String getBrand() {
        return brand;
    }

    public Date getBeforeDate() {
        return beforeDate;
    }
}

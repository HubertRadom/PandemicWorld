package pandemicworld;

import java.util.ArrayList;

public class Shop {

    private String name;
    private String address;
    private int storageCapacity;
    private ArrayList<Product> currentSupply = new ArrayList<Product>();
    private Position exit;

    Shop(Position exit, String name, String address, int storageCapacity) {
        this.name = name;
        this.address = address;
        this.storageCapacity = storageCapacity;
        this.exit = exit;
    }

    public ArrayList<Product> getCurrentSupply() {
        return currentSupply;
    }

    public void removeProduct(Product product) {
        currentSupply.remove(product);
    }

    public void addProduct(Product product) {
        currentSupply.add(product);
    }

    public String getAddress() {
        return address;
    }

    public Position getExit() {
        return exit;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }
}

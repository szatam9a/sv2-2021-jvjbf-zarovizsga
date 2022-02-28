package webshop;

public class Product {
    private long id;
    private String ProductName;
    private double price;
    private int Stock;

    public Product(long id, String productName, double price, int stock) {
        this.id = id;
        ProductName = productName;
        this.price = price;
        Stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return Stock;
    }
}

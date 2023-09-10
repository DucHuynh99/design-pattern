package structural.composite;

public class Product implements Item {
    private final double price;

    public Product(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

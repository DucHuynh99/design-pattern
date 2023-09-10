package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Box implements Item {
    private final List<Item> items = new ArrayList<>();

    public Box() {
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }
}

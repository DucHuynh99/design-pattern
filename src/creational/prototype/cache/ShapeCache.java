package creational.prototype.cache;

import creational.prototype.shapes.Circle;
import creational.prototype.shapes.Rectangle;
import creational.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
    private final Map<String, Shape> cache = new HashMap<>();

    public ShapeCache() {
        Circle circle = new Circle();
        circle.x = 1;
        circle.y = 2;
        circle.radius = 3;
        circle.color = "Red";
        cache.put("Small red circle", circle);

        Rectangle rectangle = new Rectangle();
        rectangle.x = 4;
        rectangle.y = 5;
        rectangle.height = 60;
        rectangle.width = 70;
        cache.put("Big blue rectangle", rectangle);
    }

    public void put(String key, Shape shape) {
        cache.put(key, shape);
    }

    public Shape get(String key) {
        Shape shape = cache.get(key);
        if (shape == null) return null;
        return shape.clone();
    }
}

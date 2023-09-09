package creational.prototype.shapes;

import java.util.Objects;

public abstract class Shape {
    public int x;
    public int y;
    public String color;

    public Shape(Shape other) {
        if (other != null) {
            x = other.x;
            y = other.y;
            color = other.color;
        }
    }

    public Shape() {

    }

    public abstract Shape clone();

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shape other)) return false;
        return other.x == x && other.y == y && Objects.equals(other.color, color);
    }
}

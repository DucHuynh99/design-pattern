package creational.prototype.shapes;

public class Circle extends Shape {
    public int radius;

    public Circle(Circle other) {
        super(other);
        if (other != null) {
            radius = other.radius;
        }
    }

    public Circle() {
    }

    @Override
    public Circle clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Circle other) || !super.equals(obj)) return false;
        return other.radius == radius;
    }
}

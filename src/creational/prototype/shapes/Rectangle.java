package creational.prototype.shapes;

public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(Rectangle other) {
        super(other);
        if (other != null) {
            width = other.width;
            height = other.height;
        }
    }

    public Rectangle() {

    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rectangle other) || !super.equals(obj)) return false;
        return other.width == width && other.height == height;
    }
}

package structural.adaptor.round;

public class RoundHole {
    private final double radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg roundPeg){
        return getRadius() >= roundPeg.getRadius();
    }
}

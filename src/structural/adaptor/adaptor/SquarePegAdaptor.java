package structural.adaptor.adaptor;

import structural.adaptor.round.RoundPeg;
import structural.adaptor.square.SquarePeg;

public class SquarePegAdaptor extends RoundPeg {
    private final SquarePeg squarePeg;

    public SquarePegAdaptor(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(squarePeg.getWidth() / 2, 2) * 2);
    }
}

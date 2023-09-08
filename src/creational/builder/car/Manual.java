package creational.builder.car;

import creational.builder.components.Engine;
import creational.builder.components.GPSNavigator;
import creational.builder.components.Transmission;
import creational.builder.components.TripComputer;

public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final GPSNavigator gpsNavigator;
    private final Transmission transmission;
    private final TripComputer tripComputer;

    public Manual(CarType carType, int seats, Engine engine, GPSNavigator gpsNavigator, Transmission transmission, TripComputer tripComputer) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.gpsNavigator = gpsNavigator;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type of car: ").append(carType).append("\n");
        builder.append("Count of seats: ").append(seats).append("\n");
        builder.append("Engine: volume - ").append(engine.getVolume()).append("; mileage - ").append(engine.getMileage()).append("\n");
        builder.append("GPS Navigator: ").append(gpsNavigator == null ? "N/A" : "Functional").append("\n");
        builder.append("Transmission: ").append(transmission).append("\n");
        builder.append("Trip Computer: ").append(tripComputer == null ? "N/A" : "Functional").append("\n");
        return builder.toString();
    }
}

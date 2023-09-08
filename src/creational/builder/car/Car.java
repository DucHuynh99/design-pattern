package creational.builder.car;

import creational.builder.components.Engine;
import creational.builder.components.GPSNavigator;
import creational.builder.components.Transmission;
import creational.builder.components.TripComputer;

public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final GPSNavigator gpsNavigator;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, GPSNavigator gpsNavigator, Transmission transmission, TripComputer tripComputer) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.gpsNavigator = gpsNavigator;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
}

package creational.builder.builder;

import creational.builder.car.CarType;
import creational.builder.car.Manual;
import creational.builder.components.Engine;
import creational.builder.components.GPSNavigator;
import creational.builder.components.Transmission;
import creational.builder.components.TripComputer;

public class CarManualBuilder implements Builder {
    private CarType carType;
    private int seats;
    private Engine engine;
    private GPSNavigator gpsNavigator;
    private Transmission transmission;
    private TripComputer tripComputer;

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    public Manual build() {
        return new Manual(carType, seats, engine, gpsNavigator, transmission, tripComputer);
    }
}

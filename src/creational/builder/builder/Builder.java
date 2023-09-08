package creational.builder.builder;

import creational.builder.car.CarType;
import creational.builder.components.Engine;
import creational.builder.components.GPSNavigator;
import creational.builder.components.Transmission;
import creational.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType carType);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setGPSNavigator(GPSNavigator gpsNavigator);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
}

package creational.factory_method.factory;

import creational.factory_method.transport.Transport;
import creational.factory_method.transport.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

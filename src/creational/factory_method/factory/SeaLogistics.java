package creational.factory_method.factory;

import creational.factory_method.transport.Ship;
import creational.factory_method.transport.Transport;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

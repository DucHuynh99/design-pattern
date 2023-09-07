package creational.factory_method.factory;

import creational.factory_method.transport.Transport;

public abstract class Logistics {
    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    public abstract Transport createTransport();
}

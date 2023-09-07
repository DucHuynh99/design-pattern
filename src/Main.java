import creational.factory_method.factory.Logistics;
import creational.factory_method.factory.RoadLogistics;
import creational.factory_method.factory.SeaLogistics;

public class Main {
    public static void main(String[] args) {
        Logistics logistics;
        if (System.currentTimeMillis() % 2 == 0) {
            logistics = new RoadLogistics();
        } else {
            logistics = new SeaLogistics();
        }
        logistics.planDelivery();
    }
}
import creational.abstract_factory.chair.Chair;
import creational.abstract_factory.factories.FurnitureFactory;
import creational.abstract_factory.factories.ModernFurnitureFactory;
import creational.abstract_factory.factories.VictorianFurnitureFactory;
import creational.abstract_factory.table.Table;
import creational.factory_method.factory.Logistics;
import creational.factory_method.factory.RoadLogistics;
import creational.factory_method.factory.SeaLogistics;

public class Main {
    public static void main(String[] args) {
        // FACTORY METHOD
        Logistics logistics;
        if (System.currentTimeMillis() % 2 == 0) {
            logistics = new RoadLogistics();
        } else {
            logistics = new SeaLogistics();
        }
        logistics.planDelivery();

        // ABSTRACT FACTORY
        FurnitureFactory factory;
        if (System.currentTimeMillis() % 2 == 0) {
            factory = new ModernFurnitureFactory();
        } else {
            factory = new VictorianFurnitureFactory();
        }
        Chair chair = factory.createChair();
        chair.sitOn();
        Table table = factory.createTable();
        table.placeOn();
    }
}
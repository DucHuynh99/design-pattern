import creational.abstract_factory.chair.Chair;
import creational.abstract_factory.factories.FurnitureFactory;
import creational.abstract_factory.factories.ModernFurnitureFactory;
import creational.abstract_factory.factories.VictorianFurnitureFactory;
import creational.abstract_factory.table.Table;
import creational.builder.builder.CarBuilder;
import creational.builder.builder.CarManualBuilder;
import creational.builder.car.Car;
import creational.builder.car.Manual;
import creational.builder.director.Director;
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

        // BUILDER
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.constructCityCar(carBuilder);
        Car car = carBuilder.build();
        System.out.println("New car: " + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSUV(manualBuilder);
        Manual manual = manualBuilder.build();
        System.out.println("Car manual: " + manual);
    }
}
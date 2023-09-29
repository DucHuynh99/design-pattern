import behavioral.chain_of_responsibility.middileware.Middleware;
import behavioral.chain_of_responsibility.middileware.RoleCheckMiddleware;
import behavioral.chain_of_responsibility.middileware.ThrottlingMiddleware;
import behavioral.chain_of_responsibility.middileware.UserExistsMiddleware;
import behavioral.chain_of_responsibility.server.Server;
import behavioral.command.commands.CopyCommand;
import behavioral.command.commands.CutCommand;
import behavioral.command.commands.PasteCommand;
import behavioral.command.editor.Editor;
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
import creational.prototype.cache.ShapeCache;
import creational.prototype.shapes.Circle;
import creational.prototype.shapes.Rectangle;
import creational.prototype.shapes.Shape;
import creational.singleton.ThreadOne;
import creational.singleton.ThreadThree;
import creational.singleton.ThreadTwo;
import structural.adaptor.adaptor.SquarePegAdaptor;
import structural.adaptor.round.RoundHole;
import structural.adaptor.round.RoundPeg;
import structural.adaptor.square.SquarePeg;
import structural.bridge.devices.Radio;
import structural.bridge.devices.TV;
import structural.bridge.remotes.AdvancedRemote;
import structural.bridge.remotes.BasicRemote;
import structural.composite.Box;
import structural.composite.Product;
import structural.decorator.DataSource;
import structural.decorator.FileDataSource;
import structural.decorator.decorators.CompressionDecorator;
import structural.decorator.decorators.DataSourceDecorator;
import structural.decorator.decorators.EncryptionDecorator;
import structural.facade.VideoConversionFacade;
import structural.flyweight.forest.Forest;
import structural.proxy.downloader.YoutubeDownloader;
import structural.proxy.library.ThirdPartyYoutubeClass;
import structural.proxy.proxy.YoutubeCacheProxy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        //PROTOTYPE
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "RED";
        shapes.add(circle);
        shapes.add(circle.clone());
        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "BLUE";
        shapes.add(rectangle);

        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            Shape copy = shapesCopy.get(i);
            if (shape == copy) {
                System.out.println(i + ": Shape objects are the same");
                continue;
            }
            System.out.println(i + ": Shapes are different objects");
            if (copy.equals(shape)) {
                System.out.println(i + ": But they are identical");
            } else {
                System.out.println(i + ": And they are not identical");
            }
        }

        ShapeCache cache = new ShapeCache();
        Shape shape1 = cache.get("Small red circle");
        Shape shape2 = cache.get("Big blue rectangle");
        Shape shape3 = cache.get("Big blue rectangle");
        if (shape1 != shape2 && !shape1.equals(shape2)) {
            System.out.println("Small red circle != Big blue rectangle");
        } else {
            System.out.println("Small red circle == Big blue rectangle");
        }
        if (shape2 == shape3) {
            System.out.println("Rectangle objects are the same");
        } else {
            System.out.print("Rectangles are different objects");
            if (shape3.equals(shape2)) {
                System.out.println(" but they are identical");
            } else {
                System.out.println(" and they are NOT identical");
            }
        }

        //SINGLETON
        Thread thread1 = new Thread(new ThreadOne());
        Thread thread2 = new Thread(new ThreadTwo());
        thread1.start();
        thread2.start();
        Thread thread3 = new Thread(new ThreadThree());
        Thread thread4 = new Thread(new ThreadThree());
        thread3.start();
        thread4.start();

        //ADAPTOR
        RoundHole hole = new RoundHole(5);
        RoundPeg rPeg = new RoundPeg(5);
        System.out.println("Round peg R5 fits round hole R5: " + hole.fits(rPeg));
        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        SquarePegAdaptor smallAdaptor = new SquarePegAdaptor(smallSqPeg);
        SquarePegAdaptor largeAdaptor = new SquarePegAdaptor(largeSqPeg);
        System.out.println("Square peg W2 fits round hole R5: " + hole.fits(smallAdaptor));
        System.out.println("Square peg W20 fits round hole R5: " + hole.fits(largeAdaptor));

        //BRIDGE
        Radio radio = new Radio();
        BasicRemote basicRemote = new BasicRemote(radio);
        basicRemote.power();
        basicRemote.channelDown();
        basicRemote.volumeDown();
        radio.printStatus();

        TV tv = new TV();
        AdvancedRemote advancedRemote = new AdvancedRemote(tv);
        advancedRemote.power();
        advancedRemote.channelUp();
        advancedRemote.volumeUp();
        advancedRemote.mute();
        tv.printStatus();

        //COMPOSITE
        Product product1 = new Product(1),
                product2 = new Product(2),
                product3 = new Product(3);

        Box smallBox = new Box();
        smallBox.add(product1);
        smallBox.add(product2);

        Box bigBox = new Box();
        bigBox.add(smallBox);
        bigBox.add(product3);

        System.out.println("Total price: " + bigBox.getPrice());

        //DECORATOR
        String inputString = "Huynh Huu Duc";
        DataSource plain = new FileDataSource("decorator.txt");
        DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(plain));
        encoded.write(inputString);

        System.out.println("Input: " + inputString);
        System.out.println("Encoded: " + plain.read());
        System.out.println("Decoded: " + encoded.read());

        //FACADE
        VideoConversionFacade converter = new VideoConversionFacade();
        File output = converter.convertVideo("input.mp4", "ogg");
        System.out.println(output);

        //FLYWEIGHT
        Forest forest = new Forest();
        forest.plantTree(1,2, "Apple", "Green");
        forest.plantTree(2,3, "Bamboo", "Green");
        forest.plantTree(3,4, "Apple", "Green");
        forest.plantTree(4,5, "Bamboo", "Green");
        forest.plantTree(5,6, "Coconut", "Green");
        forest.print();

        //PROXY
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());
        System.out.println("Speed test result (lower is better):");
        System.out.println("Without proxy: " + naiveDownloader.speedTest() + "ms");
        System.out.println("   With proxy: " + smartDownloader.speedTest() + "ms");

        //CHAIN OF RESPONSIBILITY
        Server server = new Server();
        server.register("admin@example.com", "admin_pw");
        server.register("user@example.com", "user_pw");
        server.setMiddleware(Middleware.link(new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()));
        System.out.println(server.login("admin@example.com", "user_pw"));
        System.out.println(server.login("admin@example.com", "admin_pw"));
        System.out.println(server.login("user1@example.com", "user_pw"));

        //COMMAND
        Editor editor = new Editor();
        editor.textField = "ABC";
        editor.render();
        editor.executeCommand(new CopyCommand(editor));
        editor.render();
        editor.executeCommand(new CutCommand(editor));
        editor.render();
        editor.executeCommand(new PasteCommand(editor));
        editor.render();
        editor.undo();
        editor.render();
    }
}
package creational.abstract_factory.factories;

import creational.abstract_factory.chair.Chair;
import creational.abstract_factory.chair.VictorianChair;
import creational.abstract_factory.table.Table;
import creational.abstract_factory.table.VictorianTable;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}

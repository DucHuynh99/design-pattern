package creational.abstract_factory.factories;

import creational.abstract_factory.chair.Chair;
import creational.abstract_factory.chair.ModernChair;
import creational.abstract_factory.table.ModernTable;
import creational.abstract_factory.table.Table;

public class ModernFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}

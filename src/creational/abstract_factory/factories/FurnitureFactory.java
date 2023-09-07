package creational.abstract_factory.factories;

import creational.abstract_factory.chair.Chair;
import creational.abstract_factory.table.Table;

public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}

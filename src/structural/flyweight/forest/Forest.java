package structural.flyweight.forest;

import structural.flyweight.trees.Tree;
import structural.flyweight.trees.TreeType;
import structural.flyweight.trees.TreeTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color) {
        TreeType type = TreeTypeFactory.getTreeType(name, color);
        trees.add(new Tree(x, y, type));
    }

    public void print() {
        System.out.println("Forest has " + trees.size() + " tree(s) of " + TreeTypeFactory.count() + " type(s)");
    }
}

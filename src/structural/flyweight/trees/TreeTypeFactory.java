package structural.flyweight.trees;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color) {
        TreeType treeType = treeTypes.get(name);
        if (treeType == null) {
            treeType = new TreeType(name, color);
            treeTypes.put(name, treeType);
        }
        return treeType;
    }

    public static int count() {
        return treeTypes.size();
    }
}

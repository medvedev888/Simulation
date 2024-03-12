package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Tree extends Entity {

    public Tree(Coordinates position, Map map) {
        super(position, map);
    }

    @Override
    public String toString() {
        return "Tree{}";
    }
}

package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Tree extends Entity {

    public Tree(Coordinates position, Map map) {
        super(position, map);
    }

    public Tree(Map map){
        super(map);
    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Tree{}";
    }
}

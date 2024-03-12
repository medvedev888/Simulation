package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Grass extends Entity {

    public Grass(Coordinates position, Map map) {
        super(position, map);
    }

    @Override
    public String toString() {
        return "Grass{}";
    }
}

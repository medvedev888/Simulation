package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Grass extends Entity {

    public Grass(Coordinates position, Map map) {
        super(position, map);
    }

    public Grass(Map map){
        super(map);
    }

    public Grass() {

    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Grass{}";
    }
}

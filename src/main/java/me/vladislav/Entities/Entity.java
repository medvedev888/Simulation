package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.Coordinates;

public abstract class Entity {
    private Coordinates position;
    private Map map;

    public Entity(Coordinates position, Map map) {
        this.position = position;
        this.map = map;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }
}

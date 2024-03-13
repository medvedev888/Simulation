package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

import java.util.Objects;

public abstract class Entity {
    private Coordinates position;
    private final Map map;

    public Entity(Coordinates position, Map map) {
        this.position = position;
        this.map = map;
    }

    public Entity(Map map) {
        this.map = map;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Map getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "position=" + position +
                ", map=" + map +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(position, entity.position) && Objects.equals(map, entity.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, map);
    }

}

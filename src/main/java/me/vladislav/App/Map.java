package me.vladislav.App;

import me.vladislav.Entities.Entity;

import java.util.HashMap;

public class Map {
    private int widht;
    private int height;
    private final HashMap<Coordinates, Entity> map;

    public Map(int width, int height){
        this.widht = width;
        this.height = height;
        map = new HashMap<>();
    }

    public void addEntity(Coordinates coordinates, Entity entity){
        map.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return map.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates){
        map.remove(coordinates);
    }

}

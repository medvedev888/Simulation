package me.vladislav.App;

import me.vladislav.Coordinates;
import me.vladislav.Entities.Entity;

import java.util.HashMap;

public class Map {
    private final HashMap<Coordinates, Entity> map = new HashMap<>();

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

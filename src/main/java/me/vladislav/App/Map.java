package me.vladislav.App;

import me.vladislav.Coordinates;
import me.vladislav.Entities.Entity;

import java.util.HashMap;

public class Map {
    private final HashMap<Coordinates, Entity> map = new HashMap<>();

    public void addToMap(Coordinates coordinates, Entity entity){
        map.put(coordinates, entity);
    }

    // get one element


}

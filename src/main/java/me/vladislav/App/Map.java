package me.vladislav.App;

import me.vladislav.Entities.Entity;

import java.util.HashMap;
import java.util.Random;

public class Map {
    private final int width;
    private final int height;
    private final HashMap<Coordinates, Entity> map;

    public Map(int width, int height){
        this.width = width;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Coordinates getCoordinatesOfFreeSpace(){
        Random random = new Random();
        Coordinates res = new Coordinates(random.nextInt(width) + 1, random.nextInt(height) + 1);
        while(map.containsKey(res)){
            res = new Coordinates(random.nextInt(width) + 1, random.nextInt(height) + 1);
        }

        return res;
    }

}

package me.vladislav.App;

import me.vladislav.Entities.Creature;
import me.vladislav.Entities.Entity;
import me.vladislav.Entities.Herbivore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public <T extends Entity> List<Coordinates> getCoordinatesSpecifiedObjects(T entity){
        List <Coordinates> listOfHerbivores = new ArrayList<>();
        for(Entity currentEntity : map.values()){
            if(currentEntity.getClass().equals(entity.getClass())){
                listOfHerbivores.add(((T) currentEntity).getPosition());
            }
        }
        return listOfHerbivores;
    }

    public <U extends Entity> List<Entity> getSpecifiedObjects(U creature){
        List <Entity> listOfCreatures = new ArrayList<>();
        for(Entity currentEntity : map.values()){
            if(currentEntity.getClass().equals(creature.getClass())){
                listOfCreatures.add(currentEntity);
            }
        }
        return listOfCreatures;
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


    public boolean containsCoordinates(Coordinates coordinates){
        return map.containsKey(coordinates);
    }

    public Coordinates getCoordinatesOfFreeSpace(){
        Random random = new Random();
        Coordinates res = new Coordinates(random.nextInt(width) + 1, random.nextInt(height) + 1);
        while(containsCoordinates(res)){
            res = new Coordinates(random.nextInt(width) + 1, random.nextInt(height) + 1);
        }

        return res;
    }

}

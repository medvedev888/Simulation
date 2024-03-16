package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public abstract class Creature extends Entity {

    private int hungerLevel;
    private int strideLength;
    private int healthPoints;

    public Creature(Coordinates position, Map map, int hungerLevel, int strideLength, int healthPoints) {
        super(position, map);
        this.hungerLevel = hungerLevel;
        this.strideLength = strideLength;
        this.healthPoints = healthPoints;
    }

    public Creature(Map map, int hungerLevel, int strideLength, int healthPoints) {
        super(map);
        this.hungerLevel = hungerLevel;
        this.strideLength = strideLength;
        this.healthPoints = healthPoints;
    }

    public Creature() {
        super();
    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getStrideLength() {
        return strideLength;
    }

    public void setStrideLength(int strideLength) {
        this.strideLength = strideLength;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public abstract boolean makeMove(Creature creature, Map map, int strideLength);

    public Coordinates checkTheNearestCoordinates(Coordinates creaturePosition, Map map) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = creaturePosition.getRow() + dir[0];
            int newCol = creaturePosition.getCol() + dir[1];

            if (map.getEntity(creaturePosition).getClass().equals(Predator.class)) {
                Entity entity = map.getEntity(new Coordinates(newRow, newCol));
                if (entity != null && entity.getClass().equals(Herbivore.class)) {
                    return new Coordinates(newRow, newCol);
                }
            } else {
                Entity entity = map.getEntity(new Coordinates(newRow, newCol));
                if (entity != null && entity.getClass().equals(Grass.class)) {
                    return new Coordinates(newRow, newCol);
                }
            }
        }
        return null;
    }

}

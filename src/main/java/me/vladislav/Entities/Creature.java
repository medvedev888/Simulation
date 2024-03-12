package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.Coordinates;

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

    public abstract void makeMove();

}

package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Herbivore extends Creature {

    public Herbivore(Coordinates position, Map map, int hungerLevel, int strideLength, int healthPoints) {
        super(position, map, hungerLevel, strideLength, healthPoints);
    }

    @Override
    public void makeMove(){

    }

    public void eat(Grass grass){

    }

}

package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator(Coordinates position, Map map, int hungerLevel, int strideLength, int healthPoints, int attackPower) {
        super(position, map, hungerLevel, strideLength, healthPoints);
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(){

    }

    public void attack(Herbivore herbivore){

    }

}

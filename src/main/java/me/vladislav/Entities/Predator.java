package me.vladislav.Entities;

import me.vladislav.Actions.MoveAction;
import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator(Coordinates position, Map map, int hungerLevel, int strideLength, int healthPoints, int attackPower) {
        super(position, map, hungerLevel, strideLength, healthPoints);
        this.attackPower = attackPower;
    }

    public Predator(Map map, int hungerLevel, int strideLength, int healthPoints, int attackPower) {
        super(map, hungerLevel, strideLength, healthPoints);
        this.attackPower = attackPower;
    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    @Override
    public void makeMove(){

    }

    public void attack(Herbivore herbivore){

    }

}

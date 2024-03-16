package me.vladislav.Entities;

import me.vladislav.Actions.MoveAction;
import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Herbivore extends Creature {

    public Herbivore(Coordinates position, Map map, int hungerLevel, int strideLength, int healthPoints) {
        super(position, map, hungerLevel, strideLength, healthPoints);
    }

    public Herbivore(Map map, int hungerLevel, int strideLength, int healthPoints){
        super(map, hungerLevel, strideLength, healthPoints);
    }

    public Herbivore() {
        super();
    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    @Override
    public void makeMove(Creature creature, Map map, int strideLength){
        MoveAction moveAction = new MoveAction(getMap(), getMap().getWidth(), getMap().getHeight());
        moveAction.makeAMove(creature, strideLength);
        getMap().removeEntity(creature.getPosition());
        Coordinates newCoordinates = moveAction.makeAMove(creature, strideLength);
        creature.setPosition(newCoordinates);
        getMap().addEntity(newCoordinates, creature);
    }

    public void eat(Grass grass){

    }

}

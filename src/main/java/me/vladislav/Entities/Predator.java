package me.vladislav.Entities;

import me.vladislav.Actions.MoveAction;
import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator(){
    }

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
    public boolean makeMove(Creature creature, Map map, int strideLength){
        MoveAction moveAction = new MoveAction(getMap(), getMap().getWidth(), getMap().getHeight());
        moveAction.makeAMove(creature, strideLength);
        getMap().removeEntity(creature.getPosition());
        Coordinates newCoordinates = moveAction.makeAMove(creature, strideLength);
        creature.setPosition(newCoordinates);
        getMap().addEntity(newCoordinates, creature);
        return true;
    }

    public boolean attack(Coordinates predatorPosition, Map map){
        Coordinates positionOfTarget = checkTheNearestCoordinates(predatorPosition, map);
        if(positionOfTarget != null){
            getMap().removeEntity(positionOfTarget);
            return true;
        } else {
            return false;
        }
    }

}

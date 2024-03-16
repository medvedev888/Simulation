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
        if(moveAction.makeAMove(creature, strideLength) == null){
            return false;
        }
        getMap().removeEntity(creature.getPosition());
        Coordinates newCoordinates = moveAction.makeAMove(creature, strideLength);
        creature.setPosition(newCoordinates);
        getMap().addEntity(newCoordinates, creature);
        return true;
    }

    public boolean attack(Coordinates predatorPosition, Map map){
        Coordinates positionOfTarget = checkTheNearestCoordinates(predatorPosition, map);
        if(positionOfTarget != null){
            System.out.println("Predator on " + predatorPosition.toString() + " attacked the herbivore on " + positionOfTarget.toString());
            ((Creature) getMap().getEntity(positionOfTarget)).setHealthPoints(((Creature) getMap().getEntity(positionOfTarget)).getHealthPoints() - this.attackPower);
            System.out.println("Herbivore on " + positionOfTarget.toString() + " loses " + this.attackPower + " health points");
            setHealthPoints(getHealthPoints() + 3);
            System.out.println("Predator on " + predatorPosition.toString() + " restores 3 health points");
            if(((Creature) getMap().getEntity(positionOfTarget)).getHealthPoints() <= 0){
                System.out.println("Herbivore on " + positionOfTarget.toString() + " is died(");
                getMap().removeEntity(positionOfTarget);
            }
            return true;
        } else {
            return false;
        }
    }

}

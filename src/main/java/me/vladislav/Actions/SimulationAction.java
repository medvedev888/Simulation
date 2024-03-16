package me.vladislav.Actions;

import me.vladislav.App.Coordinates;
import me.vladislav.App.Map;
import me.vladislav.App.Renderer;
import me.vladislav.Entities.*;

import java.util.ArrayList;
import java.util.List;

public class SimulationAction extends Action{


    public SimulationAction(Map map) {
        super(map);
    }

    public void init(int numberOfEntities, int hungerLevel, int strideLength, int healthPoints, int attackPower){
        SpawnEntityAction spawnEntityAction = new SpawnEntityAction(getMap());
        for(int i = 0; i < numberOfEntities; i++){
            spawnEntityAction.execute(new Grass(getMap()));
            spawnEntityAction.execute(new Rock(getMap()));
            spawnEntityAction.execute(new Tree(getMap()));
            spawnEntityAction.execute(new Herbivore(getMap(), hungerLevel, strideLength, healthPoints));
            spawnEntityAction.execute(new Predator(getMap(), hungerLevel, strideLength, healthPoints, attackPower));
        }
    }

    public void turn(){
        List<Entity> listOfPredator;
        listOfPredator = getMap().getSpecifiedObjects(new Predator());
        for(Entity predator : listOfPredator){
            if(!(((Predator) predator).attack(predator.getPosition(), getMap()))){
                ((Creature) predator).makeMove((Creature) predator, getMap(), ((Creature) predator).getStrideLength());
            }
        }

        List<Entity> listOfHerbivore;
        listOfHerbivore = getMap().getSpecifiedObjects(new Herbivore());
        for(Entity herbivore : listOfHerbivore){
            if(!(((Herbivore) herbivore).eat(herbivore.getPosition(), getMap()))){
                ((Creature) herbivore).makeMove((Creature) herbivore, getMap(), ((Creature) herbivore).getStrideLength());
            }
        }
    }
}

package me.vladislav.Actions;

import me.vladislav.App.Map;
import me.vladislav.Entities.*;

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

    }
}

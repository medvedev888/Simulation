package me.vladislav.Actions;

import me.vladislav.App.Map;
import me.vladislav.Entities.Grass;
import me.vladislav.Entities.Rock;

public class SimulationAction extends Action{

    public SimulationAction(Map map) {
        super(map);
    }

    public void init(int numberOfEntities){
        SpawnEntityAction spawnEntityAction = new SpawnEntityAction(getMap());
        for(int i = 0; i < numberOfEntities; i++){
            spawnEntityAction.execute(new Grass(getMap()));
            // add other entities
        }
    }

    public void turn(){

    }
}

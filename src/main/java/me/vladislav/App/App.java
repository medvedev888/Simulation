package me.vladislav.App;

import me.vladislav.Actions.MoveAction;
import me.vladislav.Actions.SimulationAction;
import me.vladislav.Entities.Creature;
import me.vladislav.Entities.Herbivore;
import me.vladislav.Entities.Predator;

public class App {
    public static void main(String[] args) {
        Map map = new Map(5, 5);
        SimulationAction simulationAction = new SimulationAction(map);
        Renderer renderer = new Renderer(map);
        Simulation simulation = new Simulation(map, renderer, simulationAction);

//        simulationAction.init(1, 2, 3, 5, 3);
//        simulation.startSimulation();

        MoveAction moveAction = new MoveAction(map, 5, 5);
        map.addEntity(new Coordinates(4, 4), new Predator(new Coordinates(4, 4), map, 5, 3, 10, 5));
        map.addEntity(new Coordinates(1, 1), new Herbivore(new Coordinates(1, 1), map, 5, 3, 10));
        renderer.mapRendering(map);
        moveAction.makeAMove((Creature) map.getEntity(new Coordinates(4, 4)), map, 4);
        renderer.mapRendering(map);

    }
}
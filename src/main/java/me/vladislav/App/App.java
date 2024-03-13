package me.vladislav.App;

import me.vladislav.Actions.SimulationAction;

public class App {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        SimulationAction simulationAction = new SimulationAction(map);
        Renderer renderer = new Renderer(map);
        Simulation simulation = new Simulation(map, renderer, simulationAction);

        simulationAction.init(5, 2, 3, 5, 3);
        simulation.startSimulation();

    }
}
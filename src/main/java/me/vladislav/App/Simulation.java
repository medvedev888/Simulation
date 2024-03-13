package me.vladislav.App;

import me.vladislav.Actions.SimulationAction;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        SimulationAction simulationAction = new SimulationAction(map);
        Renderer renderer = new Renderer(map);

        simulationAction.init(5, 2, 3, 5, 3);
        renderer.mapRendering();

    }
}
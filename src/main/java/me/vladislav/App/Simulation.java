package me.vladislav.App;

import me.vladislav.Actions.SimulationAction;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map(5, 5);
        SimulationAction simulationAction = new SimulationAction(map);
        Renderer renderer = new Renderer(map);

        simulationAction.init(5);
        renderer.mapRendering();

    }
}
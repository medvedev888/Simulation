package me.vladislav.App;

import me.vladislav.Actions.SimulationAction;

import java.util.Objects;
import java.util.Scanner;

public class Simulation {
    private final Map map;
    private int numberOfTurns = 1;
    private Renderer renderer;
    private SimulationAction simulationAction;
    private boolean isWork = false;

    public Simulation(Map map, Renderer renderer, SimulationAction simulationAction) {
        this.map = map;
        this.renderer = renderer;
        this.simulationAction = simulationAction;
    }

    public void nextTurn(){
        System.out.println("Turn: "+ numberOfTurns);
        renderer.mapRendering(map);
        numberOfTurns++;
    }

    public void startSimulation(){
        isWork = true;
        final Thread simulationThread = new Thread() {
            @Override
            public void run() {
                while (isWork) {
                    // сделать nextTurn(); и проверить работу
                    nextTurn();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        simulationThread.start();

        Scanner scanner = new Scanner(System.in);
        String input;
        while (isWork) {
            input = scanner.nextLine();
            if(Objects.equals(input, "Stop")){
                pauseSimulation();
                break;
            }
        }
        scanner.close();
    }

    public void pauseSimulation(){
        isWork = false;
    }

}

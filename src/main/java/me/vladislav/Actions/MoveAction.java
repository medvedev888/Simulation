package me.vladislav.Actions;

import me.vladislav.App.Coordinates;
import me.vladislav.App.Map;
import me.vladislav.Entities.*;

import java.util.*;

public class MoveAction {
    private Map map;
    private final int width;
    private final int hight;

    public MoveAction(Map map, int width, int hight) {
        this.map = map;
        this.width = width;
        this.hight = hight;
    }

    // returns the creature with a new coordinate after moving to the target
    public <T extends Creature> Coordinates makeAMove(T creature, Map map, int strideLength) {
        Queue<Coordinates> queue = new LinkedList<>();
        java.util.Map<Coordinates, Boolean> isVisited = new HashMap<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Coordinates start = creature.getPosition();
        isVisited.put(start, true);
        queue.add(start);

        Coordinates nearestPosition = start;
        double minDistance = Double.MAX_VALUE;

        while (!queue.isEmpty() && strideLength > 0) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Coordinates currentElement = queue.poll();

                for (int[] dir : directions) {
                    int newRow = currentElement.getRow() + dir[0];
                    int newCol = currentElement.getCol() + dir[1];
                    Coordinates newCoordinates = new Coordinates(newRow, newCol);

                    for (Coordinates herbivorePosition : map.getSpecifiedObjects(new Herbivore())) {
                        if (isAdjacentToHerbivore(newCoordinates, herbivorePosition)) {
                            System.out.println(newCoordinates.getRow() + " " + newCoordinates.getCol());
                            return newCoordinates;
                        }
                        if (checkingTheCorrectnessOfCoordinates(newCoordinates) && !isVisited.containsKey(newCoordinates)) {
                            isVisited.put(newCoordinates, true);
                            queue.add(newCoordinates);

                            double distance = calculateDistance(newCoordinates, herbivorePosition);
                            if (distance < minDistance) {
                                minDistance = distance;
                                nearestPosition = newCoordinates;
                                System.out.println(nearestPosition.getRow() + " " + nearestPosition.getCol());
                            }
                        }
                    }
                }
            }

            strideLength--;
        }

        return nearestPosition;
    }

    private boolean checkingTheCorrectnessOfCoordinates(Coordinates coordinates){
        return coordinates.getCol() > 0 && coordinates.getCol() <= width &&
                coordinates.getRow() > 0 && coordinates.getRow() <= hight &&
                !map.containsCoordinates(coordinates);
    }

    private boolean isAdjacentToHerbivore(Coordinates predatorPosition, Coordinates herbivorePosition) {
        int rowDiff = Math.abs(predatorPosition.getRow() - herbivorePosition.getRow());
        int colDiff = Math.abs(predatorPosition.getCol() - herbivorePosition.getCol());
        return (rowDiff <= 1 && colDiff <= 1);
    }

    private double calculateDistance(Coordinates a, Coordinates b) {
        int dx = a.getRow() - b.getRow();
        int dy = a.getCol() - b.getCol();
        return Math.sqrt(dx * dx + dy * dy);
    }

}

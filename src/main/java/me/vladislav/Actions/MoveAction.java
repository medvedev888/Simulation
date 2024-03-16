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

    // returns the creature with a new coordinate after moving to the target (BFS)
    public <T extends Creature> Coordinates makeAMove(T creature, int strideLength) {
        Queue<Coordinates> queue = new LinkedList<>();
        java.util.Map<Coordinates, Boolean> isVisited = new HashMap<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Coordinates start = creature.getPosition();
        isVisited.put(start, true);
        queue.add(start);

        Coordinates nearestPosition = start;
        double minDistance = Double.MAX_VALUE;
        Coordinates target;

        while (!queue.isEmpty() && strideLength > 0) {

            Coordinates currentElement = queue.poll();

            if(creature.getClass().equals(Predator.class)){
                if(getTheNearestTarget(currentElement, new Herbivore()) == null){
                    return null;
                }
                target = getTheNearestTarget(currentElement, new Herbivore()).getPosition();
            } else {
                if(getTheNearestTarget(currentElement, new Grass()) == null){
                    return null;
                }
                target = getTheNearestTarget(currentElement, new Grass()).getPosition();
            }

            for (int[] dir : directions) {
                int newRow = currentElement.getRow() + dir[0];
                int newCol = currentElement.getCol() + dir[1];
                Coordinates newCoordinates = new Coordinates(newRow, newCol);


                if (isAdjacentToHerbivore(newCoordinates, target) && checkingTheCorrectnessOfCoordinates(newCoordinates) && !isVisited.containsKey(newCoordinates)) {
                    return newCoordinates;
                }
                if (checkingTheCorrectnessOfCoordinates(newCoordinates) && !isVisited.containsKey(newCoordinates)) {
                    isVisited.put(newCoordinates, true);
                    queue.add(newCoordinates);

                    double distance = calculateDistance(newCoordinates, target);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestPosition = newCoordinates;
                    }
                }
            }


            strideLength--;
        }

        return nearestPosition;
    }

    private boolean checkingTheCorrectnessOfCoordinates(Coordinates coordinates) {
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

    public <T extends Entity> Entity getTheNearestTarget(Coordinates currentCoordinates, T entity) {
        double minDistance = Double.MAX_VALUE;
        Entity result = null;
        for (Entity target : map.getSpecifiedObjects(entity)) {


            double distance = calculateDistance(target.getPosition(), currentCoordinates);
            if (distance < minDistance) {
                minDistance = distance;
                result = target;
            }
        }
        return result;
    }

}

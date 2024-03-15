package me.vladislav.Actions;

import me.vladislav.App.Coordinates;
import me.vladislav.App.Map;
import me.vladislav.Entities.*;

import java.util.*;

public class MoveAction {
    private Map map;
    private final int width;
    private final int hight;
    private int strideLength;

    public MoveAction(Map map, int width, int hight, int strideLength) {
        this.map = map;
        this.width = width;
        this.hight = hight;
        this.strideLength = strideLength;
    }

    // возвращает новые координаты - конечную точку перемещения
    public <T extends Creature> Coordinates makeAMove(T creature, Map map){
        Queue<Coordinates> queue = new LinkedList<>();
        java.util.Map<Coordinates, Boolean> isVisited = new HashMap<>(); // isVisited
        Coordinates currentElement = null;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        isVisited.put(creature.getPosition(), true);
        queue.add(creature.getPosition());
        while(!queue.isEmpty()){
            currentElement = queue.poll();

            for (int[] dir : directions) {
                int newRow = currentElement.getRow() + dir[0];
                int newCol = currentElement.getCol() + dir[1];

                Coordinates newCoordinates = new Coordinates(newRow, newCol);

                if (checkingTheCorrectnessOfCoordinates(newCoordinates) && !isVisited.containsKey(newCoordinates)) {
                    queue.add(newCoordinates);
                    isVisited.put(newCoordinates, true);

                    if(creature instanceof Predator){
                        for (Coordinates herbivorePosition : map.getSpecifiedObjects(new Herbivore())) {
                            if (isAdjacentToHerbivore(newCoordinates, herbivorePosition)) {
                                System.out.println(newCoordinates.getRow() + " " + newCoordinates.getCol());
                                return newCoordinates;
                            }
                        }
                    } else {
                        for (Coordinates herbivorePosition : map.getSpecifiedObjects(new Grass())) {
                            if (isAdjacentToHerbivore(newCoordinates, herbivorePosition)) {
                                return newCoordinates;
                            }
                        }
                    }

                }
            }
        }
        System.out.println(creature.getPosition());
        return creature.getPosition();
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

}

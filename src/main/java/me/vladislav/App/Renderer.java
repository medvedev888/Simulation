package me.vladislav.App;

import me.vladislav.Entities.*;

public class Renderer {
    private final Map map;

    public Renderer(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

    public void mapRendering(){
        for(int i = 1; i <= map.getWidth(); i++){
            for(int j = 1; j <= map.getHeight(); j++){
                Coordinates currentCoordinates = new Coordinates(i, j);
                if(map.containsCoordinates(currentCoordinates)){
                    if(map.getEntity(currentCoordinates) instanceof Grass){
                        System.out.printf("%s ", "\uD83C\uDF3F");
                    }
                    else if(map.getEntity(currentCoordinates) instanceof Rock){
                        System.out.printf("%s ", "\uD83E\uDEA8");
                    }
                    else if(map.getEntity(currentCoordinates) instanceof Tree){
                        System.out.printf("%s ", "\uD83C\uDF34");
                    }
                    else if(map.getEntity(currentCoordinates) instanceof Herbivore){
                        System.out.printf("%s ", "\uD83D\uDC0F");
                    }
                    else if(map.getEntity(currentCoordinates) instanceof Predator){
                        System.out.printf("%s ", "\uD83D\uDC06");
                    }
                } else {
                    System.out.print("⬜ ");
                }
            }
            System.out.println();
        }
    }
}

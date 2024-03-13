package me.vladislav.App;

import me.vladislav.Entities.Grass;

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
                    // add other classes
                } else {
                    System.out.print("\u25A1   ");
                }
            }
            System.out.println();
        }
    }
}

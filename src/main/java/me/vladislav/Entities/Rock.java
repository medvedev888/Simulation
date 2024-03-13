package me.vladislav.Entities;

import me.vladislav.App.Map;
import me.vladislav.App.Coordinates;

public class Rock extends Entity {

    public Rock(Coordinates position, Map map) {
        super(position, map);
    }

    public Rock(Map map){
        super(map);
    }

    @Override
    public void setPosition(Coordinates position) {
        super.setPosition(position);
    }

    @Override
    public String toString() {
        return "Rock{}";
    }
}

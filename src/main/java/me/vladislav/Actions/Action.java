package me.vladislav.Actions;

import me.vladislav.App.Map;

public abstract class Action {
    private final Map map;

    public Action(Map map){
        this.map = map;
    }

    public Map getMap() {
        return map;
    }
}

package me.vladislav.Actions;

import me.vladislav.App.Coordinates;
import me.vladislav.App.Map;
import me.vladislav.Entities.Entity;

public class SpawnEntityAction extends Action implements SpawnAction {

    public SpawnEntityAction(Map map) {
        super(map);
    }

    @Override
    public <Ent extends Entity> void execute(Ent entity) {
        Coordinates coordinates = getMap().getCoordinatesOfFreeSpace();
        getMap().addEntity(coordinates, entity);
        entity.setPosition(coordinates);
    }
}

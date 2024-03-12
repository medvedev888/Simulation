package me.vladislav.Actions;

import me.vladislav.Entities.Entity;

public interface SpawnAction {
    public <Ent extends Entity> void execute(Ent entity);
}

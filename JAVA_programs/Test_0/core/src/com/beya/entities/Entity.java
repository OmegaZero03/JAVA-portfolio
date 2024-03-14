package com.beya.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {

    public void tick();
    public void render(SpriteBatch batch);
    public void destroy();
}

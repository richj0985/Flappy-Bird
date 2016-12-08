package com.mrlamont.flappy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    
    private SpriteBatch batch;

    // Initial Setup
    @Override
    public void create() {
        batch = new SpriteBatch();
        Gdx.gl.glClearColor(1, 0, 0, 1);
    }

    // Game Loop
    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.end();
    }

    // End Section
    @Override
    public void dispose() {
        batch.dispose();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrlamont.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mrlamont.flappy.Bird;
import com.mrlamont.flappy.FlappyBird;

/**
 *
 * @author lamon
 */
public class PlayState extends State{

    private Bird bird;
    private Texture bg;
    
    public PlayState(StateManager sm){
        super(sm);
        setCameraView(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        //setCameraPosition(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        bird = new Bird(50, 200);
        bg = new Texture("bg.png");
        
    }
    
    @Override
    public void render(SpriteBatch batch) {
        // draw the screen
        // link spritebatch to the camera
        batch.setProjectionMatrix(getCombinedCamera());
        // beginning of stuff to draw
        batch.begin();
        // draw the background
        batch.draw(bg, 0, 0);
        // draw the bird
        bird.render(batch);
        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        // update any game models
        bird.update(deltaTime);
    }

    @Override
    public void handleInput() {
        // handle any player input changes
        
        if(Gdx.input.justTouched()){
            bird.jump();
        }
    }

    @Override
    public void dispose() {
        
    }
    
}

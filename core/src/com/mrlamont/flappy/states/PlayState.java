/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrlamont.flappy.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mrlamont.flappy.Bird;

/**
 *
 * @author lamon
 */
public class PlayState extends State{

    private Bird bird;
    private Texture bg;
    
    public PlayState(StateManager sm){
        super(sm);
        
        bird = new Bird(50, 200);
        bg = new Texture("bg.png");
        
    }
    
    @Override
    public void render(SpriteBatch batch) {
        // draw the screen
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
    }

    @Override
    public void handleInput() {
        // handle any player input changes
    }

    @Override
    public void dispose() {
        
    }
    
}

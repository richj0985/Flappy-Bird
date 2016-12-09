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
import com.mrlamont.flappy.Pipe;

/**
 *
 * @author lamon
 */
public class PlayState extends State{

    private Bird bird;
    private Pipe[] pipes;
    private Texture bg;
    
    private final float CAM_X_OFFSET = 30;
    private final float PIPE_GAP_AMOUNT = 4;
    
    public PlayState(StateManager sm){
        super(sm);
        setCameraView(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        //setCameraPosition(FlappyBird.WIDTH/2, FlappyBird.HEIGHT/2);
        bird = new Bird(50, 200);
        bg = new Texture("bg.png");
        // move the camera to match the bird
        moveCameraX(bird.getX() + CAM_X_OFFSET);
        
        pipes = new Pipe[3];
        for(int i = 0; i < pipes.length; i ++){
            pipes[i] = new Pipe(200 + PIPE_GAP_AMOUNT * Pipe.WIDTH*i);
        }
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
        // draw pipes
        for(int i = 0; i < pipes.length; i ++){
            pipes[i].render(batch);
        }
        // end the stuff to draw
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        // update any game models
        bird.update(deltaTime);
        // move the camera to match the bird
        moveCameraX(bird.getX() + CAM_X_OFFSET);
        // adjust the pipes
        for(int i = 0; i < pipes.length; i ++){
            // has the bird passed the pipe
            if(getCameraX() - FlappyBird.WIDTH/4 > pipes[i].getX() + Pipe.WIDTH){
                float x = pipes[i].getX() + PIPE_GAP_AMOUNT*Pipe.WIDTH*3;
                pipes[i].setX(x);
            }
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrlamont.flappy.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

/**
 *
 * @author lamon
 */
public abstract class State {
    private OrthographicCamera cam;
    private StateManager stateManager;
    
    public State(StateManager sm){
        stateManager = sm;
        cam = new OrthographicCamera();
    }
    
    public abstract void render(SpriteBatch batch);
    public abstract void update(float deltaTime);
    public abstract void handleInput();
    public abstract void dispose();
    
    public StateManager getStateManager(){
        return stateManager;
    }
    
    public OrthographicCamera getCamera(){
        return cam;
    }
    
    public void setCameraView(float width, float height){
        cam.setToOrtho(false, width, height);
        cam.update();
    }
    
    public void setCameraPosition(float x, float y){
        cam.position.x = x;
        cam.position.y = y;
        cam.update();
    }
    
    public Matrix4 getCombinedCamera(){
        return cam.combined;
    }
}

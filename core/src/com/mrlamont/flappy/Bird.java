/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrlamont.flappy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author lamon
 */
public class Bird {
    private Vector3 position;
    private Vector3 velocity;
    private Texture birdPic;
    
    private final float GRAVITY = -15;
    
    public Bird(int x, int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        birdPic = new Texture("bird.png");
    }
    
    public void jump(){
        
    }
    
    public void update(float deltaTime){
        
    }
    
    public void render(SpriteBatch batch){
        batch.draw(birdPic, position.x, position.y);
    }
}

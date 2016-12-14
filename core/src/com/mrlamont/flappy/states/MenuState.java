/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrlamont.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mrlamont.flappy.FlappyBird;

/**
 *
 * @author richj0985
 */
public class MenuState extends State{
    
    private Texture bg;
    private Texture button;
    private int highScore;
    private BitmapFont font;
    
    public MenuState(StateManager gsm){
        super(gsm);
        bg = new Texture("bg.png");
        button = new Texture ("playbtn.png");
        
        setCameraView(FlappyBird.WIDTH, FlappyBird.HEIGHT);
        setCameraPosition(getViewWidth() / 2, getViewHeight() / 2);
        
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
        font = new BitmapFont();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(getCombinedCamera());
        batch.begin();
        batch.draw(bg, 0 , 0, getViewWidth(), getViewHeight());
        font.draw(batch, "" + highScore, getViewWidth()/2, getViewHeight() - 100);
        batch.draw(button, getViewWidth()/2 - button.getWidth()/2, getViewHeight()/2);
        batch.end();
    }

    public void updateScore(){
        Preferences pref = Gdx.app.getPreferences("highscore");
        highScore = pref.getInteger("highscore", 0);
    }
    
    @Override
    public void update(float deltaTime) {
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            unproject (touch);
            float buttonX = getViewWidth()/2 - button.getWidth()/2;
            float buttonY = getViewHeight()/2;
            if (touch.x > buttonX && touch.x < buttonX + button.getWidth() 
                    && touch.y > buttonY && touch.y < buttonY + button.getHeight()){
                StateManager gsm  = getStateManager();
                gsm.push(new PlayState(gsm));
            } 
        }
    }

    @Override
    public void dispose() {
        bg.dispose();
        button.dispose();
    }
}

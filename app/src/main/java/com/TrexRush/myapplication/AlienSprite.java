package com.TrexRush.myapplication;

import android.content.Context;

public class AlienSprite extends Sprite{
    private SpaceInvaderView game;

    public AlienSprite(Context context, SpaceInvaderView game, int x, int y) {
        super(context, R.drawable.alien, x, y);
        this.game = game;
        dx = -3;
    }

    @Override
    public void move() {
        if (((dx < 0) && (x < 10)) || ((dx > 0) && (x > 800))){
            dx = -dx;
            y += 80;
            if(y > 600){
                game.endGame();
            }
        }
        super.move();
    }
}

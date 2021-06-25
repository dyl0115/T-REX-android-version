package com.TrexRush.myapplication;

import android.content.Context;
import android.graphics.RectF;

public class StarShipSprite extends Sprite {

    RectF rect;
    SpaceInvaderView game;

    public StarShipSprite(Context context, SpaceInvaderView game, int x, int y) {
        super(context, R.drawable.starship, x, y);
        this.game = game;
        dx = 0;
        dy = 0;
    }

    public void move(){
        if ((dx < 0) && (x < 10)){
            return;
        }
        if ((dx > 0) && (x > 800)){
            return;
        }
        super.move();
    }

    @Override
    public void handleCollision(Sprite other) {
        
//        if 'other's type is AlienSprite
        if (other instanceof AlienSprite){
            game.endGame();
        }
    }
}

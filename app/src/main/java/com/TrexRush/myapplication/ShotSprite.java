package com.TrexRush.myapplication;

import android.content.Context;

public class ShotSprite extends Sprite{
    private SpaceInvaderView game;

    public ShotSprite(Context context, SpaceInvaderView game, int x, int y) {
        super(context, R.drawable.fire, x, y);

//        i can't understand code below.
        this.game = game;
        dy = -16;

    }

    public void move(){
        super.move();
        if (y < -100){
            game.removeSprite(this);
        }
    }

    @Override
    public void handleCollision(Sprite other) {
        if (other instanceof AlienSprite){
            game.removeSprite(this);
            game.removeSprite(other);
        }
    }
}

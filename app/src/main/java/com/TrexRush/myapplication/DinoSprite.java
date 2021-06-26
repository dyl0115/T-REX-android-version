package com.TrexRush.myapplication;

import android.content.Context;

public class DinoSprite extends Sprite{
    private FieldView game;

    public DinoSprite(Context context, FieldView game, int x, int y) {
        super(context, R.drawable.introdino, x, y);
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

    public void jump(){
        if ((dy > 0) && (y > 20)){
            return;
        }
        super.move();
    }

}

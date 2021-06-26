package com.TrexRush.myapplication;

import android.content.Context;

public class DinoSprite extends Sprite{
    private FieldView game;
    private int DinoLeftMost;
    private int DinoRightMost;
    private int DinoTopMost;
    private int DinoBottomMost;

    private int DinoSpeed;
    private int DinoJumpSpeed;

    public DinoSprite(Context context, FieldView game, int x, int y) {
        super(context, R.drawable.playerdino, x, y);
        DinoLeftMost = 50;
        DinoRightMost = 1600;
        DinoTopMost = 450;
        DinoBottomMost = 900;

        DinoSpeed = 40;
        DinoJumpSpeed = -30;
    }

    public void move(){
        if ((dx < 0) && (x < DinoLeftMost)){
            return;
        }
        if ((dx > 0) && (x > DinoRightMost)){
            return;
        }
        super.move();
    }

//여기 바꿈.
    public void moveLeft(){
        if ((dx < 0) && (x < DinoLeftMost)){
            return;
        }
        else{
            dx = -1 * DinoSpeed;
        }
    }

    public void moveRight(){
        if ((dx > 0) && (x> DinoRightMost)){
            return;
        }
        else{
            dx = DinoSpeed;
        }
    }
//

    public void jump(){
        if ((y > DinoTopMost)){
            dy = DinoJumpSpeed;
        }
        super.move();
    }

}

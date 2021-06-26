
package com.TrexRush.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class FieldView extends SurfaceView implements Runnable {
    private Context context;
    private Thread gameThread = null;
    private SurfaceHolder ourHolder;
    private volatile boolean running;
    private Canvas canvas;
    private Paint paint;
    private int screenW, screenH;

    private ArrayList sprites = new ArrayList();
//    private Sprite Dino;
    private DinoSprite Dino;

    private int FrameCounter;

    private int DinoSpeed;
    private int DinoInitY;
    private int DinoInitX;

    private float jump_key_area;
    private float moving_key_area;
    private float left_right_key_boundary;

    public FieldView(Context context, int x, int y) {
        super(context);
        this.context = context;
        ourHolder = getHolder();
        paint = new Paint();
        screenW = x;
        screenH = y;

        FrameCounter = 0;

        DinoInitY = screenH * 8 / 10;
        DinoInitX = screenW * 1 / 10;
        DinoSpeed = 40;

        jump_key_area = screenW * 1 / 10;
        moving_key_area = screenW * 7 /10 ;
        left_right_key_boundary = screenW * 9 / 10;

        startGame();
    }

    private void initSprites(){
        Dino = new DinoSprite(context, this, DinoInitX, DinoInitY);
        sprites.add(Dino);
    }

    private void startGame() {
        sprites.clear();
        initSprites();
    }

    public void endGame(){
        System.exit(0);
    }

    @Override
    public void run() {
        while(running){

            FrameCounter += 1;

            for (int i = 0; i <sprites.size(); i++){
                Sprite sprite = (Sprite) sprites.get(i);
                sprite.move();
            }
            draw();
        }

    }

    private void draw() {
        if (ourHolder.getSurface().isValid()){
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.WHITE);
            for (int i =0; i <sprites.size(); i++){
                Sprite sprite = (Sprite) sprites.get(i);
                sprite.draw(canvas, paint);
            }
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int switchInt = motionEvent.getAction() & MotionEvent.ACTION_MASK;
        switch (switchInt){
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                if (motionEvent.getX() < screenW * 3 / 10)
                    
//                    점프
                    if (motionEvent.getX() < jump_key_area)
                        Dino.jump();

//                방향키
                if (motionEvent.getX() > moving_key_area)

//                    왼쪽으로 이동
                    if (motionEvent.getX() < left_right_key_boundary )
//                        Dino.setDx(-1 * DinoSpeed); 여기를 지웠음.
                        Dino.moveLeft();

//                    오른쪽으로 이동
                    else
//                        Dino.setDx(DinoSpeed);
                        Dino.moveRight();
                break;
            case MotionEvent.ACTION_UP:
                Dino.setDx(0);
                Dino.setDy(0);
                break;
        }
        return true;
    }

    public void resume() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void pause() {
        running = false;
        try {
            gameThread.join();
        }
        catch (InterruptedException e){

        }
    }
}

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
    private Sprite Dino;

    public FieldView(Context context, int x, int y) {
        super(context);
        this.context = context;
        ourHolder = getHolder();
        paint = new Paint();
        screenW = x;
        screenH = y;
        startGame();
    }

    private void initSprites(){
        Dino = new DinoSprite(context, this, screenW /5, screenH /5);
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
            canvas.drawColor(Color.BLUE);
            paint.setColor(Color.BLUE);
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
                if(motionEvent.getX() > screenW * 4 / 5)
                    if(motionEvent.getX() < screenW * 9 / 10 )
                        Dino.setDx(-10);
                    else
                        Dino.setDx(+10);
                break;
            case MotionEvent.ACTION_UP:
                Dino.setDx(0);
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

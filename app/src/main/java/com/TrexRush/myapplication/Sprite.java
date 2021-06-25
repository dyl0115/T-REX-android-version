package com.TrexRush.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Sprite {

//    현재 좌표
    protected int x, y;

//    화면의 크기
    protected int width, height;

//    속도
    protected int dx, dy;

//    이미지
    private Bitmap bitmap;

//    이미지 리소스 아이디
    protected int id;

//    사각형, 충돌 검사에 사용
    private RectF rect;

    public Sprite(Context context, int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
        bitmap = BitmapFactory.decodeResource(context.getResources(),id);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        rect = new RectF();
    }

    public int getWidth(){
        return bitmap.getWidth();
    }

    public int getHeight(){
        return bitmap.getHeight();
    }

    public void draw(Canvas g, Paint p){
        g.drawBitmap(bitmap, x, y, p);
    }

    public void move(){
        x += dx;
        y += dy;
        rect.left = x;
        rect.right = x + width;
        rect.top = y;
        rect.bottom = y + height;
    }

    public void setDx(int dx){
        this.dx = dx;
    }

    public void setDy(int dy){
        this.dy = dy;
    }

    public int getDx(){
        return dx;
    }

    public int getDy(){
        return dy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public RectF getRect(){
        return rect;
    }

    public boolean checkCollision(Sprite other){
        return RectF.intersects(this.getRect(),other.getRect());
    }

    public void handleCollision(Sprite other){

    }
}

package com.TrexRush.myapplication;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
//    SpaceInvaderView spaceInvaderView;
    FieldView fieldView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        fieldView = new FieldView(this, size.x, size.y);
        setContentView(fieldView);
//        spaceInvaderView = new SpaceInvaderView(this, size.x, size.y);
//        setContentView(spaceInvaderView);

    }

    protected void onResume(){
        super.onResume();
        fieldView.resume();
//        spaceInvaderView.resume();
    }


    protected void onPause(){
        super.onPause();
        fieldView.pause();
//        spaceInvaderView.pause();
    }
}

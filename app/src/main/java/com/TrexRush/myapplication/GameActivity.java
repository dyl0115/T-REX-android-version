package com.TrexRush.myapplication;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    SpaceInvaderView spaceInvaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        spaceInvaderView = new SpaceInvaderView(this, size.x, size.y);
        setContentView(spaceInvaderView);

    }

    protected void onResume(){
        super.onResume();
        spaceInvaderView.resume();
    }

    protected void onPause(){
        super.onPause();
        spaceInvaderView.pause();
    }
}

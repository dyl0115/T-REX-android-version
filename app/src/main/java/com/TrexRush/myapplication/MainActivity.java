package com.TrexRush.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
    }


    public void btn_start_click(View view) {
        Toast myToast = Toast.makeText(this.getApplicationContext(),"Game Start Clicked!", Toast.LENGTH_SHORT);
        myToast.show();
        Intent start_intent=new Intent(getApplicationContext(), GameActivity.class);
        startActivity(start_intent);
    }

    public void btn_board_click(View view) {
        Toast myToast = Toast.makeText(this.getApplicationContext(),"Score Board Clicked!", Toast.LENGTH_SHORT);
        myToast.show();
        Intent score_intent=new Intent(getApplicationContext(),ScoreActivity.class);
        startActivity(score_intent);

    }

    public void btn_credit_click(View view) {
        Toast myToast = Toast.makeText(this.getApplicationContext(),"Credit Clicked!", Toast.LENGTH_SHORT);
        myToast.show();
        Intent credit_intent=new Intent(getApplicationContext(),CreditActivity.class);
        startActivity(credit_intent);
    }

    public void btn_introdino_click(View view) {
        Toast myToast = Toast.makeText(this.getApplicationContext(),"Intro Dino Clicked!", Toast.LENGTH_SHORT);
        myToast.show();
    }
}

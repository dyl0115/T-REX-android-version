package com.TrexRush.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main)
    }

    fun btn_start_click(view: View) {
        Toast.makeText(getApplicationContext(),"Game Start Clicked!",Toast.LENGTH_SHORT).show();
    }

    fun btn_board_click(view: View) {
        Toast.makeText(getApplicationContext(),"Score Board Clicked!",Toast.LENGTH_SHORT).show();
    }

    fun btn_credit_click(view: View) {
        Toast.makeText(getApplicationContext(),"Credit Clicked!",Toast.LENGTH_SHORT).show();
    }

    fun btn_introdino_click(view: View) {
        Toast.makeText(getApplicationContext(),"Intro Dino Clicked!",Toast.LENGTH_SHORT).show();
    }

}
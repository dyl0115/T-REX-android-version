package com.TrexRush.myapplication;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity{

    MediaPlayer mainmenu_bgm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//반복되는 배경음악 넣기
        mainmenu_bgm = MediaPlayer.create(this,R.raw.walkongrass);
        mainmenu_bgm.setLooping(true);
//


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.intro_activity);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

//              배경음악 재생
                mainmenu_bgm.start();
//
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


    }

    protected void onPause(){
        super.onPause();
        finish();
    }

}

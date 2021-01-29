package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Portada extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);
        mp=MediaPlayer.create(this,R.raw.vaquero);
        mp.start();
        mp.setLooping(true);
    }

    public void clic(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        Thread time=new Thread(){
            @Override
            public void run() {
                try {
                    mp.stop();
                    mp=MediaPlayer.create(Portada.this,R.raw.disparo);
                    mp.start();

                    sleep(500);

                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    startActivity(intent);
                    Animatoo.animateSlideLeft(Portada.this);
                    finish();
                }
            }
        };
        time.run();


    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }
}
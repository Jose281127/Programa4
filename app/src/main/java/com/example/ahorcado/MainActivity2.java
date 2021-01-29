package com.example.ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity2 extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mp= MediaPlayer.create(this,R.raw.risa);
        mp.start();
    }

    public void clic(View view) {
        Intent intent= new Intent(this,MainActivity.class);
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.disparo);
        mp.start();

        startActivity(intent);
        Animatoo.animateInAndOut(this);
        finish();
    }

    public void clico(View view) {
        Intent intent= new Intent(this,Portada.class);
        mp.stop();
        mp=MediaPlayer.create(this,R.raw.disparo);
        mp.start();

        startActivity(intent);
        Animatoo.animateInAndOut(this);
        finish();
    }
}
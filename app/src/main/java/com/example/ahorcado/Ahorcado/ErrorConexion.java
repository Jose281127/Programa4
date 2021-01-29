package com.example.ahorcado.Ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ahorcado.MainActivity;
import com.example.ahorcado.R;

public class ErrorConexion extends AppCompatActivity {
MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_conexion);
        mp=MediaPlayer.create(this,R.raw.sms);
        mp.start();
    }

    public void clic(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        mp=MediaPlayer.create(this,R.raw.disparo);
        mp.start();
        startActivity(intent);
        Animatoo.animateZoom(this);
        finish();
    }
}
package com.example.carzone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
MediaPlayer mysong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysong=MediaPlayer.create(MainActivity.this,R.raw.carzhorn);
    }
    public void openActivity(View v){
        Toast.makeText(this,"loading..",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public void playIT(View v){
        mysong.start();


    }
}
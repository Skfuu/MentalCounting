package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void Play(View v){
        startActivity(new Intent(MainActivity.this, GameActivity.class));
    }
    public void Score(View v){
        startActivity(new Intent(MainActivity.this, ScoreActivity.class));
    }
}


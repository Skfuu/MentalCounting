package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView nboperations = findViewById(R.id.calculations_number);
        TextView derniereoperation = findViewById(R.id.last_calculation);
        TextView pourcentage = findViewById(R.id.winrate);
        ImageButton back = findViewById(R.id.return_button);

        nboperations.setText(Integer.toString(ScoreBDD.getNboperations()));
        derniereoperation.setText(ScoreBDD.getDerniereOperation());
        pourcentage.setText(Double.toString(ScoreBDD.Pourcentage()));
        back.setOnClickListener(view -> finish());
    }



}
package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private TextView operation;
    private TextView bonnereponse;
    private TextView mauvaisereponse;
    private EditText reponse;
    private int resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        operation = findViewById(R.id.calculation_textview);
        bonnereponse = findViewById(R.id.answer_right);
        mauvaisereponse = findViewById(R.id.answer_wrong);
        reponse = findViewById(R.id.answer_edittext);

        bonnereponse.setVisibility(View.INVISIBLE);
        mauvaisereponse.setVisibility(View.INVISIBLE);

        Button boutonvalider = findViewById(R.id.submit_button);
        boutonvalider.setOnClickListener(view -> validation());
        Jeu();
    }

    public void Home(View v){
        startActivity(new Intent(GameActivity.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.GameMenuScorePageButton:
                startActivity(new Intent(getApplicationContext(),ScoreActivity.class));
                break;
            case R.id.GameMenuScoreEraseButton:
                ScoreBDD.ResetScore();
                Toast.makeText(getApplicationContext(), getString(R.string.GameMenuScoreEraseButtonText), Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    private static int Random(int lowerBound, int upperBound) {
        int range = (upperBound - lowerBound) + 1;

        return (int)(Math.random() * range) + lowerBound;
    }

    private void Jeu(){
        int premierNombre = Random(0,15);
        int deuxiemeNombre = Random(0,15);
        int signe = Random(0,3);
        String str_operation = null;

        switch (signe){
            case 0:
                str_operation = "+";
                resultat = premierNombre + deuxiemeNombre;
                break;
            case 1:
                str_operation = "-";
                resultat = premierNombre - deuxiemeNombre;
                break;
            case 2:
                str_operation = "*";
                resultat = premierNombre * deuxiemeNombre;
                break;
            case 3:
                str_operation = "/";
                resultat = premierNombre / deuxiemeNombre;
                break;
        }

        String calcul = premierNombre + " " + str_operation + " " + deuxiemeNombre;
        operation.setText(calcul);
        ScoreBDD.setDerniereOperation(calcul + " = " + resultat);

    }

    private void validation() {
        if (reponse.getText().toString().isEmpty())
            return;

        if (Integer.parseInt(reponse.getText().toString()) == resultat) {
            bonnereponse.setVisibility(View.VISIBLE);
            mauvaisereponse.setVisibility(View.INVISIBLE);
            ScoreBDD.nouvelleOperation();
            Jeu();
        } else {
            bonnereponse.setVisibility(View.INVISIBLE);
            mauvaisereponse.setVisibility(View.VISIBLE);
        }

        reponse.setText("");
        ScoreBDD.nouvelleTentative();
    }
}
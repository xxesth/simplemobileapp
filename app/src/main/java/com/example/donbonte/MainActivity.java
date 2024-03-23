package com.example.donbonte;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.donbonte.R;


public class MainActivity extends AppCompatActivity {
    Button button;
    TextView missiontext;
    TextView score;
    SharedPreferences numeroPreferences;

    Integer[] lestachesetquestions = {R.string.welcometext, R.string.tache1, R.string.question1,R.string.tache2, R.string.question2,R.string.tache3, R.string.question3,R.string.tache4, R.string.question4, R.string.tache5, R.string.question5,R.string.tache6, R.string.question6,R.string.tache7, R.string.question7,R.string.tache8, R.string.question8, R.string.tache9, R.string.question9,R.string.tache10, R.string.question10,R.string.tache11, R.string.question11,R.string.tache12, R.string.question12, R.string.tache13, R.string.question13,R.string.tache14, R.string.question14,R.string.tache15, R.string.question15,R.string.tache16, R.string.question16, R.string.finishtext};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //System.out.println(lestachesetquestions[0]);
        missiontext = findViewById(R.id.missionText);
        score = findViewById(R.id.scoreText);
        button = findViewById(R.id.button4);
        //missiontext.setTypeface(getResources().getFont(R.font.baskervville_italic));
        //score.setTypeface(getResources().getFont(R.font.baskervville));
        //button.setTypeface(getResources().getFont(R.font.baskervville_italic));
        numeroPreferences = this.getSharedPreferences("numero", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = numeroPreferences.edit();
        int numero = numeroPreferences.getInt("numero", 0);
        int minusnumero = 33-numero;
        score.setText(""+minusnumero);
        missiontext.setText(lestachesetquestions[numero]);
        editor.commit();
        if (numero == 0){
            button.setText(R.string.startfait);
        } else if (numero == 33) {
            button.setText(R.string.finishfait);
        }else{
            button.setText(R.string.jaifait);
        }

    }

    public void jaifait(View view){
        int numero = numeroPreferences.getInt("numero", 0);
        if (numero >= 33){
            numero = 0;
            numeroPreferences.edit().putInt("numero", numero).commit();
        }else{
            numero += 1;
        }
        if (numero == 0){
            button.setText(R.string.startfait);
        } else if (numero == 33) {
            button.setText(R.string.finishfait);
        }else{
            button.setText(R.string.jaifait);
        }
        int minusnumero = 33-numero;
        missiontext.setText(lestachesetquestions[numero]);
        score.setText(""+minusnumero);
        numeroPreferences.edit().putInt("numero", numero).commit();
    }
    public void gomenu(View view){
        Intent gomenu = new Intent(MainActivity.this, menu.class);
        startActivity(gomenu);
    }

    public void golog(View view){
        Intent golog = new Intent(MainActivity.this, log.class);
        int gonumero = numeroPreferences.getInt("numero", 0);
        golog.putExtra("monnumero",gonumero);
        startActivity(golog);
    }

}
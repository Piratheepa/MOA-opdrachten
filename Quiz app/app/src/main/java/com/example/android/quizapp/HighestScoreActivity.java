package com.example.android.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView textScore = (TextView) findViewById(R.id.textScore);
        TextView textHighScore = (TextView) findViewById(R.id.textHighScore);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        textScore.setText("Your score:" + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if(highscore>=score)
        {
            textHighScore.setText("High score: " + highscore);
        }else{
            textHighScore.setText("New highscore: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }
    }

    public void onclick(View view) {
        Intent intent = new Intent(HighestScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

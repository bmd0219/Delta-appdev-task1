package com.example.appdev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView rscore;
    private TextView rstreak;
    private int score;
    private int streak;
    private Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        score = intent.getIntExtra(MainActivity.RES_SCORE,0);
        streak = intent.getIntExtra(MainActivity.RES_STREAK,0);

        rscore = (TextView)findViewById(R.id.rscore);
        rstreak = (TextView)findViewById(R.id.rstreak);
        restart = (Button)findViewById(R.id.restart);

        rscore.setText("SCORE : " + String.valueOf(score));
        rstreak.setText("LONGEST STREAK : " + String.valueOf(streak));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart1();
            }
        });

        if(savedInstanceState != null){

            score = savedInstanceState.getInt("score");
            streak = savedInstanceState.getInt("streak");
            rscore.setText("SCORE : " + String.valueOf(score));
            rstreak.setText("LONGEST STREAK : " + String.valueOf(streak));

        }
    }

    public void restart1(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("score",score);
        outState.putInt("streak",streak);
    }
}

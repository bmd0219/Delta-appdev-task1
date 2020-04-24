package com.example.appdev1copy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private Button play;
    private TextView vlstreak;
    private TextView vhscore;
    public int highscore;
    public int longstreak;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SCORE = "score";
    public static String STREAK = "streak";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        play = (Button)findViewById(R.id.play);
        vlstreak = (TextView)findViewById(R.id.lstreak);
        vhscore = (TextView)findViewById(R.id.hscore);

        gethsls();

        vhscore.setText("HIGHEST SCORE : " + String.valueOf(highscore));
        vlstreak.setText("LONGEST STREAK : " + String.valueOf(longstreak));

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openactivity2();
            }
        });
    }

    private void openactivity2(){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void gethsls(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore = sharedPreferences.getInt(SCORE,0);
        longstreak = sharedPreferences.getInt(STREAK,0);
    }
}

package com.example.bmd_ffactorh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button send;
    private Button finish;
    private EditText info;
    private TextView res;
    private TextView vscore;
    private TextView vstreak;
    private int h = 0;
    private long num1;
    private long num2;
    private long num3;
    private long numc = 1;
    private int r;
    private int u;
    private String result;
    private ConstraintLayout rl;
    public int score = 0;
    private int streak = 0;
    private int color = 0;
    private int color1 = 0;
    private int color2 = 0;
    private int color3 = 0;
    public int highscore;
    public int longstreak;
    public int longstreak1 = 0;
    private CountDownTimer countdown;
    private boolean timerrunning;
    private static final long time = 10000;
    private long timeleft = time;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SCORE = "score";
    public static final String STREAK = "streak";
    public static final String RES_SCORE = "com.example.appdev1.example.RES_SCORE";
    public static final String RES_STREAK = "com.example.appdev1.example.RES_STREAK";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupuiviews();

        gethsls();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //waity();
//                rl.setBackgroundColor(Color.argb(255,214,215,215));
                h = 1;
                factor();

//                send.setText("TRY1");
                if(h == 1){
                    one.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            u = 1;
                            check(u);
                        }
                    });

                    two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            u = 2;
                            check(u);
                        }
                    });

                    three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            u = 3;
                            check(u);
                        }
                    });
//                    send.setText("TRY2");
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish1();

            }
        });

        if(savedInstanceState != null){
            num1 = savedInstanceState.getLong("num1");
            num2 = savedInstanceState.getLong("num2");
            num3 = savedInstanceState.getLong("num3");
            numc = savedInstanceState.getLong("numc");
            score = savedInstanceState.getInt("score");
            streak = savedInstanceState.getInt("streak");
            longstreak1 = savedInstanceState.getInt("longstreak1");
            h = savedInstanceState.getInt("h");
            u = savedInstanceState.getInt("u");
            r = savedInstanceState.getInt("r");
            color = savedInstanceState.getInt("color");
            color1 = savedInstanceState.getInt("color1");
            color2 = savedInstanceState.getInt("color2");
            color3 = savedInstanceState.getInt("color3");
            result = savedInstanceState.getString("result");
            rl.setBackgroundColor(color);
            one.setBackgroundColor(color1);
            two.setBackgroundColor(color2);
            three.setBackgroundColor(color3);
            one.setText(String.valueOf(num1));
            two.setText(String.valueOf(num2));
            three.setText(String.valueOf(num3));
            if(h == 1){
                one.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        u = 1;
                        check(u);
                    }
                });

                two.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        u = 2;
                        check(u);
                    }
                });

                three.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        u = 3;
                        check(u);
                    }
                });
//                    send.setText("TRY2");
            }
            vscore.setText("SCORE : " + String.valueOf(score));
            vstreak.setText("STREAK : " + String.valueOf(streak));
            res.setText(result);
        }

    }

    private void setupuiviews()
    {
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        info = (EditText)findViewById(R.id.input);
        send = (Button)findViewById(R.id.Send);
        res = (TextView)findViewById(R.id.result);
        rl = (ConstraintLayout)findViewById(R.id.layout1);
        vscore = (TextView)findViewById(R.id.score);
        vstreak = (TextView)findViewById(R.id.streak);
        finish = (Button)findViewById(R.id.finish);
    }

    private void waity(){
        send.setText("WAIT");
    }

    private void factor() {
        res.setText("Choose the option");
        rl.setBackgroundColor(Color.argb(110,130,133,127));
        one.setBackgroundColor(Color.argb(255,215,214,214));
        two.setBackgroundColor(Color.argb(255,215,214,214));
        three.setBackgroundColor(Color.argb(255,215,214,214));
        if(info.getText().toString().equals("")){
            h = 0;
            res.setText("Enter a number");
            return;
        }
        long number = Long.parseLong(info.getText().toString());
        if(number <= 4){
            h = 0;
            res.setText("Try another number");
            one.setText("Option 1");
            two.setText("Option 2");
            three.setText("Option 3");
        }

        else{
            r = 1 + (int) (new Random().nextFloat() * (3 - 1));
            int r1 = (int) (new Random().nextFloat() * (2));
            boolean j = true;
            long numsq = (long)Math.sqrt(number);

            num1 = 1 + random(numsq - 1);
            long l;
            long m;
            if (r == 1) {
                j = false;
                m = num1;
                l = num1;
                while((number % l != 0) && (number % m != 0)){
                    l -= 1;
                    m += 1;
                }
                if(number % l == 0){
                    num1 = l;
                }
                else{
                    num1 = m;
                }
                if(r1 == 0){
                    num1 = num1;
                }
                else{
                    num1 = number / num1;
                }
                if(num1 == numc){
                    num1 = number / num1;
                }
                numc = num1;
            }
            while (j) {
                num1 = 1 + random(number - 1);
                if (number % num1 != 0) {
                    j = false;
                }
            }
            one.setText(String.valueOf(num1));
            j = true;
            num2 = 1 + random(numsq - 1);
            if (r == 2) {
                j = false;
                m = num2;
                l = num2;
                while((number % l != 0) && (number % m != 0)){
                    l -= 1;
                    m += 1;
                }
                if(number % l == 0){
                    num2 = l;
                }
                else{
                    num2 = m;
                }
                if(r1 == 0){
                    num2 = num2;
                }
                else{
                    num2 = number / num2;
                }
                if(num2 == numc){
                    num2 = number / num2;
                }
                numc = num2;
            }
            while (j) {
                num2 = 1 + random(number - 1);
                if ((number % num2 != 0) && (num2 != num1)) {
                    j = false;
                }
            }
            two.setText(String.valueOf(num2));
            j = true;
            num3 = 1 + random(numsq - 1);
            if (r == 3) {
                j = false;
                m = num3;
                l = num3;
                while((number % l != 0) && (number % m != 0)){
                    l -= 1;
                    m += 1;
                }
                if(number % l == 0){
                    num3 = l;
                }
                else{
                    num3 = m;
                }
                if(r1 == 0){
                    num3 = num3;
                }
                else{
                    num3 = number / num3;
                }
                if(num3 == numc){
                    num3 = number / num3;
                }
                numc = num3;
            }
            while (j) {
                num3 = 1 + random(number - 1);
                if ((number % num3 != 0) && (num3 != num2) && (num3 != num1)) {
                    j = false;
                }
            }
            three.setText(String.valueOf(num3));
        }
//        send.setText("TRY4");
    }

    private long random(long k){
        long generatedLong = (long) (Math.random() * (k));
        return generatedLong;
    }

    private void check(int u) {
//        info.setText("");
        if (u == r && h == 1) {
            score += 1;
            streak += 1;
            updatescorestreak();
            res.setText("CORRECT");
            rl.setBackgroundColor(Color.argb(150,9,154,24));
            if (u == 1)
                one.setBackgroundColor(Color.argb(255, 9, 154, 24));
            else if (u == 2)
                two.setBackgroundColor(Color.argb(255, 9, 154, 24));
            else
                three.setBackgroundColor(Color.argb(255, 9, 154, 24));
            h = 0;
        }
        else {
            if (h == 1) {
                score -= 1;
                if(streak > longstreak1) {
                    longstreak1 = streak;
                }
                streak = 0;
                updatescorestreak();
                rl.setBackgroundColor(Color.argb(200,247,65,54));
                if (r == 1) {
                    res.setText("INCORRECT\nCorrect answer-" + String.valueOf(num1));
                    one.setBackgroundColor(Color.argb(255, 9, 154, 24));
                } else if (r == 2) {
                    res.setText("INCORRECT\nCorrect answer-" + String.valueOf(num2));
                    two.setBackgroundColor(Color.argb(255, 9, 154, 24));
                } else {
                    res.setText("INCORRECT\nCorrect answer-" + String.valueOf(num3));
                    three.setBackgroundColor(Color.argb(255, 9, 154, 24));
                }
                if (u == 1)
                    one.setBackgroundColor(Color.argb(255, 247, 65, 54));
                else if (u == 2)
                    two.setBackgroundColor(Color.argb(255, 247, 65, 54));
                else
                    three.setBackgroundColor(Color.argb(255, 247, 65, 54));
            }
            h = 0;
        }
    }

    public void savehsls(){
        if(score >= highscore){
            highscore = score;
        }
        if(streak >= longstreak1){
            longstreak1 = streak;
        }
        if(longstreak1 >= longstreak){
            longstreak = longstreak1;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE,highscore);
        editor.putInt(STREAK,longstreak);
        editor.apply();
    }

    public void gethsls(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore = sharedPreferences.getInt(SCORE,0);
        longstreak = sharedPreferences.getInt(STREAK,0);
    }

    private void updatescorestreak(){
        vscore.setText("SCORE : " + String.valueOf(score));
        vstreak.setText("STREAK : " + String.valueOf(streak));
    }

    private void finish1(){
        savehsls();
        Intent intent = new Intent(this,Result.class);
        intent.putExtra(RES_SCORE,score);
        intent.putExtra(RES_STREAK,longstreak1);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        ColorDrawable viewcolor = (ColorDrawable)rl.getBackground();
        color = viewcolor.getColor();
        ColorDrawable viewcolor1 = (ColorDrawable)one.getBackground();
        color1 = viewcolor1.getColor();
        ColorDrawable viewcolor2 = (ColorDrawable)two.getBackground();
        color2 = viewcolor2.getColor();
        ColorDrawable viewcolor3 = (ColorDrawable)three.getBackground();
        color3 = viewcolor3.getColor();
        result = res.getText().toString();
        outState.putInt("score",score);
        outState.putInt("streak",streak);
        outState.putInt("longstreak1",longstreak1);
        outState.putLong("num1",num1);
        outState.putLong("num2",num2);
        outState.putLong("num3",num3);
        outState.putLong("numc",numc);
        outState.putInt("h",h);
        outState.putInt("u",u);
        outState.putInt("r",r);
        outState.putInt("color",color);
        outState.putInt("color1",color1);
        outState.putInt("color2",color2);
        outState.putInt("color3",color3);
        outState.putString("result",result);
    }
}


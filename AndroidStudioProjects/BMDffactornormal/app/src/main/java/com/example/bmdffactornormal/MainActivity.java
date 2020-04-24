package com.example.bmdffactornormal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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
    private EditText info;
    private TextView res;
    private int h = 0;
    private long num1;
    private long num2;
    private long num3;
    private int r;
    private int u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupuiviews();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waity();
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

    }

    private void setupuiviews()
    {
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        info = (EditText)findViewById(R.id.input);
        send = (Button)findViewById(R.id.Send);
        res = (TextView)findViewById(R.id.result);
    }

    private void waity(){
        send.setText("WAIT");
    }

    private void factor() {
        res.setText("Choose the option");
        one.setBackgroundColor(Color.argb(255,215,214,214));
        two.setBackgroundColor(Color.argb(255,215,214,214));
        three.setBackgroundColor(Color.argb(255,215,214,214));
        long number = Long.parseLong(info.getText().toString());
//        send.setText("TRY3");
        if(info.getText().toString().equals(null))
            number = -1;
//        int arrnum;
//        arrnum = (number+number%2)/2 + 2;
//        f = new int[arrnum];
//        for(int i = 0;i < arrnum; ++i) {
//            f[i] = 0;
//        }
//        c = 0;
//        for(int i = 1; i <= number; ++i) {
//            if (number % i == 0) {
//                f[c] = i;
//                c += 1;
//            }
//        }
//        send.setText(String.valueOf(number));
        if(number == -1)
        {
            h = 0;
            res.setText("Enter a number");
        }
        else if(number <= 4){
            h = 0;
            res.setText("Try another number");
            one.setText("Option 1");
            two.setText("Option 2");
            three.setText("Option 3");
        }

        else{
            if(number > 1000000007)
//                send.setText("WAIT");
            h = 1;
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
        if (u == r && h == 1) {
            res.setText("CORRECT");
            if (u == 1)
                one.setBackgroundColor(Color.argb(255, 9, 154, 24));
            else if (u == 2)
                two.setBackgroundColor(Color.argb(255, 9, 154, 24));
            else
                three.setBackgroundColor(Color.argb(255, 9, 154, 24));
        } else {
            if (h == 1) {
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
        }
    }


}

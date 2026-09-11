package com.example.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        TextView gretings = findViewById(R.id.gretings);
        TextView orientation = findViewById(R.id.screenOrientation);
        TextView number = findViewById(R.id.number);

        int size = getResources().getInteger(R.integer.medium);
        gretings.setTextSize(size);

        checkOrientation();
        randomNumber();
    }
    public void checkOrientation(){
        TextView screenOrientation = findViewById(R.id.screenOrientation);
        int orientation = getResources().getConfiguration().orientation;


        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            screenOrientation.setText("PIONOWA");
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            screenOrientation.setText("POZIOMA");
        } else {
            screenOrientation.setText("NIEZNANA");
        }

    }
    public void randomNumber(){
        Random random = new Random();
        int number = random.nextInt(10);
        TextView numb = findViewById(R.id.number);
        numb.setText(String.valueOf(number));
    }
}
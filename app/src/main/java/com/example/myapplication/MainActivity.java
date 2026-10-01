package com.example.myapplication;

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

//        TextView gretings = findViewById(R.id.gretings);
//        TextView orientation = findViewById(R.id.screenOrientation);
//        TextView number = findViewById(R.id.number);
//        int size = getResources().getInteger(R.integer.medium);
//        gretings.setTextSize(size);

//        checkOrientation();
        randomNumber();
    }
//    public void checkOrientation(){
//        TextView screenOrientation = findViewById(R.id.screenOrientation);
//        screenOrientation.setText(getString(R.string.screenOrientation));
//    }
    public void randomNumber(){
        TextView rectangle = findViewById(R.id.rectangle);
        Random random = new Random();
        int number = random.nextInt(5);

        rectangle.setText(String.valueOf(number));
        switch (number){
            case 0:
                rectangle.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case 1:
                rectangle.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case 2:
                rectangle.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 3:
                rectangle.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 4:
                rectangle.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }
    }
}
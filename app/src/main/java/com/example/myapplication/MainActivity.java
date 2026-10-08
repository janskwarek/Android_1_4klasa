package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        if (savedInstanceState != null) {
            rotationsCount = savedInstanceState.getInt("rotations", 0);
        }
        TextView text1 = findViewById(R.id.text1);
        text1.setText(String.valueOf(rotationsCount));
    }
    int rotationsCount = 0;
    protected void onSaveInstanceState(Bundle outState){
        rotationsCount++;
        outState.putInt("rotations", rotationsCount);
        super.onSaveInstanceState(outState);
    }

}
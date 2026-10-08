package com.example.myapplication;

import android.content.res.Configuration;
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
            rotationsHorizontalCount = savedInstanceState.getInt("rotationsHorizontal", 0);
            rotationsVerticalCount = savedInstanceState.getInt("rotationsVertical", 0);
        }
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        text1.setText(String.valueOf(rotationsHorizontalCount));
        text2.setText(String.valueOf(rotationsVerticalCount));
    }
    int rotationsVerticalCount = 0;
    int rotationsHorizontalCount = 0;
    protected void onSaveInstanceState(Bundle outState){
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rotationsHorizontalCount++;
        } else {
            rotationsVerticalCount++;
        }
        outState.putInt("rotationsHorizontal", rotationsHorizontalCount);
        outState.putInt("rotationsVertical", rotationsVerticalCount);
        super.onSaveInstanceState(outState);

    }

}
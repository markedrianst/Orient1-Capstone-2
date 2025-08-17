package com.example.orient1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class lessons_module extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons_module);

        // Back button
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Oval Button 1 - opens Dctculture activity
        Button ovalButton1 = findViewById(R.id.ovalButton1);
        ovalButton1.setOnClickListener(v -> {
            Intent intent = new Intent(lessons_module.this, Dctculture.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Oval Button 2 - opens SnP activity
        Button ovalButton2 = findViewById(R.id.ovalButton2);
        ovalButton2.setOnClickListener(v -> {
            Intent intent = new Intent(lessons_module.this, SnP.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Oval Button 3 - opens IOL3 activity
        Button ovalButton3 = findViewById(R.id.ovalButton3);
        ovalButton3.setOnClickListener(v -> {
            Intent intent = new Intent(lessons_module.this, IOL3.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Oval Button 4 - open EAL4 activity
        Button ovalButton4 = findViewById(R.id.ovalButton4);
        ovalButton4.setOnClickListener(v -> {
            Intent intent = new Intent(lessons_module.this, EAL4.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // Oval Button 5 - open IOEAL5 activity
        Button ovalButton5 = findViewById(R.id.ovalButton5);
        ovalButton5.setOnClickListener(v -> {
            Intent intent = new Intent(lessons_module.this, IOEAL5.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }
}

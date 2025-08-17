package com.example.orient1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class quiz_module extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_module);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back button line
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(quiz_module.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            finish();
        });

        // Dynamic Quiz Category Handling
        Map<Integer, String> quizCategories = new HashMap<>();
        quizCategories.put(R.id.ovalButton1, "Dominican College of Tarlac Culture");
        quizCategories.put(R.id.ovalButton2, "Study and Prayer Life");
        quizCategories.put(R.id.ovalButton3, "Introduction on Student Life");
        quizCategories.put(R.id.ovalButton4, "Education And Learning");
        quizCategories.put(R.id.ovalButton5, "Importance of Education And Learning");

        for (Map.Entry<Integer, String> entry : quizCategories.entrySet()) {
            Button button = findViewById(entry.getKey());
            if (button != null) {
                button.setOnClickListener(v -> {
                    Intent intent = new Intent(quiz_module.this, quizlevel.class);
                    intent.putExtra("quizCategory", entry.getValue()); // Pass category dynamically
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                });
            }
        }
    }
}
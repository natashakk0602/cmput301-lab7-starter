package com.example.androiduitesting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView city = findViewById(R.id.text_city_name);
        Button back = findViewById(R.id.button_back);

        String name = getIntent().getStringExtra("city_name");
        city.setText(name);

        back.setOnClickListener(v -> finish());
    }
}
package com.chien.secondui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Page2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        textView = findViewById(R.id.textView);

        Intent it2 = getIntent();
        String name2 = it2.getStringExtra("name");
        textView.setText(name2);
    }
}
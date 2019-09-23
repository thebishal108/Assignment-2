package com.example.assignment_2.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assignment_2.R;

public class Activity_Home_Page extends AppCompatActivity {
TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__home__page);
        message = findViewById(R.id.tv_message);
        Intent i = getIntent();
        message.setText("Welcome\n"+i.getStringExtra("message"));
    }
}

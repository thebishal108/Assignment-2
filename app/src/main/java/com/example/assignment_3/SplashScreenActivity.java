package com.example.assignment_3;

import android.content.Intent;
import android.os.Bundle;

import com.example.assignment_3.StudentData.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    ArrayList<String> studentName = new ArrayList<String>();
    ArrayList<Integer> studentClass = new ArrayList<Integer>();
    ArrayList<Integer> studentRollNo = new ArrayList<Integer>();
    ArrayList<Data> data = new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        studentName.add("Bishal");
        studentName.add("Kunal");
        studentClass.add(10);
        studentClass.add(9);
        studentRollNo.add(42);
        studentRollNo.add(43);

        for (int x = 0; x < studentName.size(); x++) {
            data.add(new Data(studentName.get(x), studentClass.get(x), studentRollNo.get(x)));
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, HomeActivity.class);
                i.putExtra("STUDENTNAME", studentName);
                i.putExtra("STUDENTCLASS", studentClass);
                i.putExtra("STUDENTROLLNO", studentRollNo);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}

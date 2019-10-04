package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.assignment_3.StudentData.Data;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
EditText etname,etclass, etrollno;
    ArrayList<String> studentName = new ArrayList<String>();
    ArrayList<Integer> studentClass = new ArrayList<Integer>();
    ArrayList<Integer> studentRollNo = new ArrayList<Integer>();
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        etname = findViewById(R.id.et_student_name);
        etclass = findViewById(R.id.et_class);
        etrollno = findViewById(R.id.et_roll_no);
        Intent intent = getIntent();
        studentName = (ArrayList<String>) intent.getSerializableExtra("STUDENTNAME");
        studentClass = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTCLASS");
        studentRollNo = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTROLLNO");
        position = (Integer) intent.getSerializableExtra("POSITION");
        etname.setText(studentName.get(position));
        etclass.setText(String.valueOf(studentClass.get(position)));
        etrollno.setText(String.valueOf(studentRollNo.get(position)));
    }
}

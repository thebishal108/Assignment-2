package com.example.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.assignment_3.StudentData.Data;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {
    EditText etstdname,etclass, etrollno;
    FrameLayout flstdname, flclass, flrollno, flsubmit;
    ArrayList<String> studentName = new ArrayList<String>();
    ArrayList<Integer> studentClass = new ArrayList<Integer>();
    ArrayList<Integer> studentRollNo = new ArrayList<Integer>();
    int position;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        flstdname = findViewById(R.id.fl_student_name);
        flclass = findViewById(R.id.fl_class);
        flrollno = findViewById(R.id.fl_roll_no);
        flsubmit = findViewById(R.id.fl_submit);
        etstdname = findViewById(R.id.et_student_name);
        etclass = findViewById(R.id.et_class);
        etrollno = findViewById(R.id.et_roll_no);
        update = findViewById(R.id.btn_update);
        Intent intent = getIntent();
        studentName = (ArrayList<String>) intent.getSerializableExtra("STUDENTNAME");
        studentClass = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTCLASS");
        studentRollNo = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTROLLNO");
        position = (Integer) intent.getSerializableExtra("POSITION");
        etstdname.setText(studentName.get(position));
        etclass.setText(String.valueOf(studentClass.get(position)));
        etrollno.setText(String.valueOf(studentRollNo.get(position)));
        etstdname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    flstdname.setBackgroundResource(R.color.colorPrimary);
                    etstdname.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    flsubmit.setBackgroundResource(R.color.greycolordisabled);
                } else {
                    flstdname.setBackgroundResource(R.color.greycolordisabled);
                    etstdname.setHintTextColor(getResources().getColor(R.color.greycolor));
                    flsubmit.setBackgroundResource(R.color.colorPrimary);
                }
            }
        });
        etclass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    flclass.setBackgroundResource(R.color.colorPrimary);
                    etclass.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    flsubmit.setBackgroundResource(R.color.greycolordisabled);
                } else {
                    flclass.setBackgroundResource(R.color.greycolordisabled);
                    etclass.setHintTextColor(getResources().getColor(R.color.greycolor));
                    flsubmit.setBackgroundResource(R.color.colorPrimary);
                }
            }
        });
        etrollno.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    flrollno.setBackgroundResource(R.color.colorPrimary);
                    etrollno.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    flsubmit.setBackgroundResource(R.color.greycolordisabled);
                } else {
                    flrollno.setBackgroundResource(R.color.greycolordisabled);
                    etrollno.setHintTextColor(getResources().getColor(R.color.greycolor));
                    flsubmit.setBackgroundResource(R.color.colorPrimary);
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(String.valueOf(etstdname.getText()).equals(""))
                {
                    Toast.makeText(UpdateActivity.this,getResources().getString(R.string.enter_name), Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(String.valueOf(etclass.getText()).equals(""))
                    {
                        Toast.makeText(UpdateActivity.this,getResources().getString(R.string.enter_class), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if(Integer.parseInt(String.valueOf(etclass.getText()))<1||Integer.parseInt(String.valueOf(etclass.getText()))>12)
                        {
                            Toast.makeText(UpdateActivity.this,getResources().getString(R.string.invalid_class),Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            if(String.valueOf(etrollno.getText()).equals(""))
                            {
                                Toast.makeText(UpdateActivity.this,getResources().getString(R.string.enter_roll_no), Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                studentName.set(position,String.valueOf(etstdname.getText()));
                                studentClass.set(position,Integer.parseInt(String.valueOf(etclass.getText())));
                                studentRollNo.set(position,Integer.parseInt(String.valueOf(etrollno.getText())));
                                Intent i = new Intent(UpdateActivity.this,HomeActivity.class);
                                i.putExtra("STUDENTNAME", studentName);
                                i.putExtra("STUDENTCLASS", studentClass);
                                i.putExtra("STUDENTROLLNO", studentRollNo);
                                startActivity(i);
                            }
                        }
                    }
                }
            }
        });
    }
}

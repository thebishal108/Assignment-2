package com.example.assignment_3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.assignment_3.Adapter.StudentAdapter;
import com.example.assignment_3.Interface.datatransfer;
import com.example.assignment_3.StudentData.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements datatransfer {
    Button btnAddStudent;
    int position;
    TextView emptyinfo;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> studentName = new ArrayList<String>();
    ArrayList<Integer> studentClass = new ArrayList<Integer>();
    ArrayList<Integer> studentRollNo = new ArrayList<Integer>();
    ArrayList<Data> data = new ArrayList<Data>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        studentName = (ArrayList<String>) intent.getSerializableExtra("STUDENTNAME");
        studentClass = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTCLASS");
        studentRollNo = (ArrayList<Integer>) intent.getSerializableExtra("STUDENTROLLNO");
        for (int x = 0; x < studentName.size(); x++) {
            data.add(new Data(studentName.get(x), studentClass.get(x), studentRollNo.get(x)));
        }
        emptyinfo = findViewById(R.id.tv_empty_student_list_info);
        btnAddStudent = findViewById(R.id.btn_add_student);
        mRecyclerView = findViewById(R.id.rl_student_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new StudentAdapter(data, this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        if (data.size() > 0) {
            emptyinfo.setVisibility(View.GONE);
        }
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, AddStudentActivity.class);
                i.putExtra("STUDENTNAME", studentName);
                i.putExtra("STUDENTCLASS", studentClass);
                i.putExtra("STUDENTROLLNO", studentRollNo);
                startActivity(i);
            }
        });
    }

    @Override
    public void getPosition(final int pos, final boolean flag) {
        position = pos;
        final TextView dialogview, dialogedit, dialogdelete;
        if (flag == true) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_options);
            dialogview = dialog.findViewById(R.id.tv_view);
            dialogedit = dialog.findViewById(R.id.tv_edit);
            dialogdelete = dialog.findViewById(R.id.tv_delete);
            dialogview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(HomeActivity.this,ViewActivity.class);
                    i.putExtra("STUDENTNAME", studentName);
                    i.putExtra("STUDENTCLASS", studentClass);
                    i.putExtra("STUDENTROLLNO", studentRollNo);
                    i.putExtra("POSITION",position);
                    dialog.dismiss();
                    startActivity(i);

                }
            });
            dialogedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(HomeActivity.this,UpdateActivity.class);
                    i.putExtra("STUDENTNAME", studentName);
                    i.putExtra("STUDENTCLASS", studentClass);
                    i.putExtra("STUDENTROLLNO", studentRollNo);
                    i.putExtra("POSITION",position);
                    dialog.dismiss();
                    startActivity(i);
                }
            });
            dialogdelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    studentName.remove(position);
                    studentClass.remove(position);
                    studentRollNo.remove(position);
                    Intent i = new Intent(HomeActivity.this,HomeActivity.class);
                    i.putExtra("STUDENTNAME", studentName);
                    i.putExtra("STUDENTCLASS", studentClass);
                    i.putExtra("STUDENTROLLNO", studentRollNo);
                    i.putExtra("POSITION",position);
                    startActivity(i);
                }
            });
            dialog.show();
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.sort:
                Toast.makeText(HomeActivity.this, "You Clicked About", Toast.LENGTH_LONG).show();
                return true;
            case R.id.list:
                Toast.makeText(HomeActivity.this, "You Clicked Help", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

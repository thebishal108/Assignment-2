package com.example.assignment_3.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_3.HomeActivity;
import com.example.assignment_3.Interface.datatransfer;
import com.example.assignment_3.R;
import com.example.assignment_3.StudentData.Data;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<Data> studentList;
    public datatransfer dt;
    boolean flag = false;

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView studentName;
        public TextView studentClass;

        public StudentViewHolder(View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.tv_student_name);
            studentClass = itemView.findViewById(R.id.tv_student_class);

        }
    }

    public StudentAdapter(ArrayList<Data> studentList, datatransfer datatransfer) {
        this.studentList = studentList;
        dt = datatransfer;
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customrow, parent, false);
        StudentViewHolder studentViewHolder = new StudentViewHolder(v);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, final int position) {
        final Data currentStudent = studentList.get(position);
        holder.studentName.setText("Name: " + currentStudent.getStudentName());
        holder.studentClass.setText("Class: " + String.valueOf(currentStudent.getStudentClass()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag=true;
                dt.getPosition(position,flag);

            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}

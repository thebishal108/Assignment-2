package com.example.assignment_3.StudentData;

public class Data {
    private String studentName;
    private int studentClass;
    private int studentRollNo;

    public Data(String studentName, int studentClass, int studentRollNo) {
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }
}

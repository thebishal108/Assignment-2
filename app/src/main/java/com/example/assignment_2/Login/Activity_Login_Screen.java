package com.example.assignment_2.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.assignment_2.Home.Activity_Home_Page;
import com.example.assignment_2.R;
import com.example.assignment_2.Sign_Up.Activity_Sign_Up;
import com.example.assignment_2.data.data;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


public class Activity_Login_Screen extends AppCompatActivity{
    boolean flag=false;
    data userdata = new data();
    Button login;
    TextView register;
    EditText etname;
    TextInputEditText etpassword;
    String name,genderlist,email,password,usertype,occupation,dateofbirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login__screen);
        etname = findViewById(R.id.et_name);
        etpassword = findViewById(R.id.et_password);
        login =  findViewById(R.id.btn_login);
        register = findViewById(R.id.tv_register);
        etname.setText("");
        etpassword.setText("");
        name= "Bishal";
        genderlist = "Male";
        email = "thebishal108@gmail.com";
        password = "123";
        usertype = "Average" ;
        occupation = "Computer Engineer";
        dateofbirth = "25/09/1994";
        userdata.adddata(name,genderlist,email,password,usertype,occupation,dateofbirth);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etname.getText().toString().equals(""))
                {
                    if(!etpassword.getText().toString().equals(""))
                    {
                        flag = userdata.matchdata(etname.getText().toString(),etpassword.getText().toString());
                        if(flag)
                        {
                            Intent intent = new Intent(Activity_Login_Screen.this, Activity_Home_Page.class);
                            intent.putExtra("message",etname.getText().toString());
                            startActivity(intent);
                        }
                        else {
                            Snackbar.make(view, "Invalid Credentials", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                    else
                    {
                        Snackbar.make(view, "Please enter your password", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
                else
                {
                    Snackbar.make(view, "Please enter your Name", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Login_Screen.this, Activity_Sign_Up.class);
                startActivity(i);
            }
        });
    }
}

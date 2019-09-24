package com.example.assignment_2.Sign_Up;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_2.Login.Activity_Login_Screen;
import com.example.assignment_2.OTP.Activity_OTP_Screen;
import com.example.assignment_2.R;
import com.example.assignment_2.data.data;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Activity_Sign_Up extends AppCompatActivity {
    EditText etdateOfBirth, etName, etEmail, etPassword, etUserType, etOccupation;
    ImageView goBack;
    TextView differentAcc;
    Calendar myCalendar = Calendar.getInstance();
    Button cont;
    data datatransfer = new data();
    RadioButton male,female,transgender;
    RadioGroup gender;
    String name,genderlist,email,password,usertype,occupation,dateofbirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sign__up);
        gender = (RadioGroup) findViewById(R.id.rg_gender);
        male = (RadioButton) findViewById(R.id.rb_male);
        female = (RadioButton) findViewById(R.id.rb_female);
        transgender = (RadioButton) findViewById(R.id.rb_transgender);
        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email_id);
        etPassword = (EditText) findViewById(R.id.et_password);
        etUserType = (EditText) findViewById(R.id.et_user_type);
        etOccupation = (EditText) findViewById(R.id.et_occupation);
        cont = (Button) findViewById(R.id.btn_continue);
        etdateOfBirth = (EditText) findViewById(R.id.et_date_of_birth);
        goBack = (ImageView) findViewById(R.id.img_get_back);
        differentAcc = (TextView) findViewById(R.id.tv_different_account);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!etName.getText().toString().equals(""))
                {
                    if (gender.getCheckedRadioButtonId() == -1)
                    {
                        Snackbar.make(view, "Please select your gender", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                    else
                    {
                        if(!etdateOfBirth.getText().toString().equals(""))
                        {
                            if(!etEmail.getText().toString().equals(""))
                            {
                                if (!etPassword.getText().toString().equals(""))
                                {
                                    if(!etUserType.getText().toString().equals(""))
                                    {
                                        if(!etOccupation.getText().toString().equals(""))
                                        {
                                            name = etName.getText().toString();
                                            if(male.isSelected())
                                            {
                                                genderlist =  male.getText().toString();
                                            }
                                            else if (female.isSelected())
                                            {
                                                genderlist = female.getText().toString();
                                            }
                                            else
                                            {
                                                genderlist = transgender.getText().toString();
                                            }
                                            dateofbirth = etdateOfBirth.getText().toString();
                                            email = etEmail.getText().toString();
                                            password = etPassword.getText().toString();
                                            usertype = etUserType.getText().toString();
                                            occupation = etOccupation.getText().toString();
                                            datatransfer.adddata(name,genderlist,email,password,usertype,occupation,dateofbirth);
                                            Intent i = new Intent(Activity_Sign_Up.this, Activity_OTP_Screen.class);
                                            i.putExtra("message",name);
                                            startActivity(i);

                                        }
                                        else
                                        {
                                            Snackbar.make(view, "Please enter your Occupation", Snackbar.LENGTH_LONG)
                                                    .setAction("Action", null).show();
                                        }
                                    }
                                    else
                                    {
                                        Snackbar.make(view, "Please enter your User Type", Snackbar.LENGTH_LONG)
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
                                Snackbar.make(view, "Please enter your Email Id", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                        }
                        else
                        {
                            Snackbar.make(view, "Please enter your Date of Birth", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                }
                else
                {
                    Snackbar.make(view, "Please enter your full name", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        etdateOfBirth.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Activity_Sign_Up.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        etdateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    new DatePickerDialog(Activity_Sign_Up.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        });


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Sign_Up.this, Activity_Login_Screen.class);
                startActivity(i);
            }
        });
        differentAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_Sign_Up.this, Activity_Login_Screen.class);
                startActivity(i);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etdateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }
}

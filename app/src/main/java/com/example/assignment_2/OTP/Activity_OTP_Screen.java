package com.example.assignment_2.OTP;

import android.content.Intent;
import android.os.Bundle;

import com.example.assignment_2.Login.Activity_Login_Screen;
import com.example.assignment_2.Sign_Up.Activity_Sign_Up;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.assignment_2.R;

public class Activity_OTP_Screen extends AppCompatActivity {
    int otp = 8513;
    EditText otp_1, otp_2, otp_3, otp_4;
    Button resend,submit;
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__otp__screen);
        resend = findViewById(R.id.btn_resend);
        submit = findViewById(R.id.btn_submit);
        otp_1 = (EditText) findViewById(R.id.otp_entry1);
        otp_2 = (EditText) findViewById(R.id.otp_entry2);
        otp_3 = (EditText) findViewById(R.id.otp_entry3);
        otp_4 = (EditText) findViewById(R.id.otp_entry4);
        back = (ImageView) findViewById(R.id.img_get_back);
        otp_1.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "OTP has been again send to you phone", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!otp_1.getText().toString().equals("")&&!otp_2.getText().toString().equals("")&&!otp_3.getText().toString().equals("")&&!otp_4.getText().toString().equals(""))
                {
                    int temp=0;
                    temp = temp*10+Integer.parseInt(otp_1.getText().toString());
                    temp = temp*10+Integer.parseInt(otp_2.getText().toString());
                    temp = temp*10+Integer.parseInt(otp_3.getText().toString());
                    temp = temp*10+Integer.parseInt(otp_4.getText().toString());
                    if(temp == otp)
                    {
                        Intent i = new Intent(Activity_OTP_Screen.this, Activity_Login_Screen.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Wrong input", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
                else
                {
                    Snackbar.make(view, "Please enter the four digit otp", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        otp_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_1.getText().toString().length() == 1) {
                    otp_2.requestFocus();
                }
            }
        });
        otp_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_2.getText().toString().length() == 1) {
                    otp_3.requestFocus();
                }
            }
        });
        otp_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_3.getText().toString().length() == 1) {
                    otp_4.requestFocus();
                }
            }
        });
        otp_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (otp_4.getText().toString().length() == 1) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity_OTP_Screen.this.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(otp_4.getWindowToken(), 0);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity_OTP_Screen.this, Activity_Sign_Up.class);
                startActivity(i);
            }
        });
    }
}

package com.example.triptracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.stream.Stream;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailEditText, mPasswordEditText, mNameEditText;
    private TextView mSwitchTXT;
    private Button mLoginButton, mRegisterButton; //m for hungarian syntax

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailEditText = findViewById(R.id.enter_email);
        mPasswordEditText = findViewById(R.id.enter_password);
        mSwitchTXT = findViewById(R.id.switchView_Text);
        mLoginButton = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.registerBTN);
        mNameEditText = findViewById(R.id.nameEditText);


        LogInOnClickListener loc = new LogInOnClickListener();
        SwitchViewOnCLickListener svoc = new SwitchViewOnCLickListener();
        RegisterOnClickListener roc = new RegisterOnClickListener();

        mLoginButton.setOnClickListener(loc);
        mSwitchTXT.setOnClickListener(svoc);
        mRegisterButton.setOnClickListener(roc);
    }
    //inner classes for LoginActivity
    private class LogInOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //move activities
            String enteredEmail = mEmailEditText.getText().toString();
            String enteredPassword = mPasswordEditText.getText().toString();
            if (enteredEmail.equals("fehn@gmail.com") && enteredPassword.equals("123456")) {
                Intent i = new Intent(LoginActivity.this, StreamActivity.class);
                startActivity(i);
            }else{
                Toast.makeText(LoginActivity.this,"Username or Password is incorrect", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private class SwitchViewOnCLickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (mNameEditText.getVisibility()==View.GONE) {
                mNameEditText.setVisibility(View.VISIBLE);
                mRegisterButton.setVisibility(View.VISIBLE);
                mLoginButton.setVisibility(View.GONE);
                mSwitchTXT.setText("Back to Log In");
            }else{
                mNameEditText.setVisibility(View.GONE);
                mRegisterButton.setVisibility(View.GONE);
                mLoginButton.setVisibility(View.VISIBLE);
                mSwitchTXT.setText("Need to register?");
            }
        }
    }
    private class RegisterOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String name = mNameEditText.getText().toString().trim();
            String email = mEmailEditText.getText().toString().trim();
            String password = mPasswordEditText.getText().toString().trim();
            //build if statement to check if all functions return true
        }

        public Boolean nameCheck(String name){
            if(name.equals("")){
                return false;
            }else{
                return true;
            }
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public Boolean emailCheck(String email){
            String[] emailSplit = email.split("@");
            boolean left = false;
            boolean right = false;
            boolean oneAt = false;

            if ((emailSplit.length)==2){
                oneAt=true;
            }
            if (((Arrays.stream(emailSplit).toArray())[0]).toString().length() > 0){
                left=true;
            }
            if (((Arrays.stream(emailSplit).toArray())[1]).toString().length() > 0){
                right=true;
            }

            if (left && right && oneAt) {
                return true;
            }else{
                return false;
            }
        }
        public Boolean passwordCheck(String password){
            String[] specialCharacters = {"!","#","%","&","+","_","-","?","'","~","$"};
            boolean length = false;
            boolean capAndLower = false;
            boolean symbol = false;

            if (password.length() >= 8){
                length=true;
            }
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                    capAndLower = true;
                }
            }
            //build for loop to check for symbols

            //build if statement to check if bools are true (return true)
        }
    }
}
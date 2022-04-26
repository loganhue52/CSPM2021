package com.example.passwordmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmailEditText, mPasswordEditText, mNameEditText;
    private TextView mSwitchTXT;
    private Button mLoginButton, mRegisterButton; //m for hungarian syntax
    private String mEmail,mPassword;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        mEmail = "fehn@gmail.com";
//        mPassword = "123456";

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

        mFirebaseAuth = FirebaseAuth.getInstance();
    }
    //inner classes for LoginActivity
    private class LogInOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //move activities
            String enteredEmail = mEmailEditText.getText().toString();
            String enteredPassword = mPasswordEditText.getText().toString();

            mFirebaseAuth.signInWithEmailAndPassword(enteredEmail,enteredPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent i = new Intent(LoginActivity.this, StreamActivity.class);
                        i.putExtra("title","Public Trips");
                        startActivity(i);
                    }else{
                        Toast.makeText(LoginActivity.this,"Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            });

//            if (enteredEmail.equals(mEmail) && enteredPassword.equals(mPassword)) {
//                Intent i = new Intent(LoginActivity.this, StreamActivity.class);
//                startActivity(i);
//            }else{
//                Toast.makeText(LoginActivity.this,"Username or Password is incorrect", Toast.LENGTH_SHORT).show();
//            }
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
            if (nameCheck(name) && emailCheck(email) && passwordCheck(password)){
//                mEmail=email;
//                mPassword=password;
////                mNameEditText.setVisibility(View.GONE);
////                mRegisterButton.setVisibility(View.GONE);
////                mLoginButton.setVisibility(View.VISIBLE);
////                mSwitchTXT.setText("Need to register?");
////                startActivity(new Intent(LoginActivity.this,LoginActivity.class));
//                mEmailEditText.setText(mEmail);
//                mPasswordEditText.setText(mPassword);
                mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this,LoginActivity.class));
                            //each user is given a unique user ID in firebase, may need this later
                        }else{
                            Toast.makeText(LoginActivity.this,"Registration falied",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else {
                if (!(nameCheck(name))) {
                    Toast.makeText(LoginActivity.this, "Name not valid", Toast.LENGTH_SHORT).show();
                }
                if (!(emailCheck(email))) {
                    Toast.makeText(LoginActivity.this, "Email not valid", Toast.LENGTH_SHORT).show();
                }
                if (!(passwordCheck(password))) {
                    Toast.makeText(LoginActivity.this, "Password not valid", Toast.LENGTH_SHORT).show();
                }
            }

        }

        public Boolean nameCheck(String name){
            if(name.isEmpty()){
                mNameEditText.requestFocus();
                return false;
            }else{
                return true;
            }
        }

        public Boolean emailCheck(String email){
            String[] emailSplit = email.split("@");
            Log.e("Email array: ",emailSplit.toString());
            boolean left = false;
            boolean right = false;
            boolean oneAt = false;

            if (email.isEmpty()){
                mEmailEditText.requestFocus();
                return false;
            }

            if ((emailSplit.length)==2){
                oneAt=true;
            }
            //ERROR HERE
            if (emailSplit[0].length() > 0){
                left=true;
            }
            if (emailSplit[1].length() > 0){
                right=true;
            }

            if (left && right && oneAt) {
                return true;
            }else{
                return false;
            }
        }
        public Boolean passwordCheck(String password){
            String[] specialCharacters = {"!","#","%","&","+","_","-","?","'","~","$","@"};
            boolean length = false;
            boolean cap = false;
            boolean lower = false;
            //make this false
            boolean symbol = true;

            if (password.isEmpty()){
                mPasswordEditText.requestFocus();
                return false;
            }

            if (password.length() >= 8){
                length=true;
            }
            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if ((ch >= 'A' && ch <= 'Z')) {
                    cap = true;
                }else if ((ch >= 'a' && ch <= 'z')){
                    lower = true;
                }else {
                    //build for loop to check for symbols
                    for (String j : specialCharacters) {
                        //fix this
                        if (j.equals(ch)) {
                            symbol = true;
                            break;
                        }
                    }
                }
            }

            //build if statement to check if bools are true (return true)
            if (length && cap && lower && symbol){
                return true;
            }else{
                return false;
            }
        }
    }
}
package com.example.simplecalc; //unique id for the program

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//extend the AppCompatActivity class
    private EditText n1TXT; //initializing global vars
    private EditText n2TXT;
    private Button addBTN;
    private Button subBTN;
    private Button divBTN;
    private Button mulBTN;
    private TextView out;

    @Override   //override the default template
    protected void onCreate(Bundle savedInstanceState) { //first ran function
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //this line links the two files



        n1TXT = findViewById(R.id.eT1);
        n2TXT = findViewById(R.id.eT2);

        addBTN = findViewById(R.id.addBtn);
        subBTN = findViewById(R.id.subBtn);
        divBTN = findViewById(R.id.divBtn);
        mulBTN = findViewById(R.id.mulBtn);

        out = findViewById(R.id.output);


    }
    public void test(){
        String input = String.valueOf(n1TXT.getText());
    }
}
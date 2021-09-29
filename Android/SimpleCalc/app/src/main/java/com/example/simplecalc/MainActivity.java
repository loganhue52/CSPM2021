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

        //set up the button with an algorithm
        divBTN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(n1TXT.getText()));
                int num2 = Integer.parseInt(String.valueOf(n2TXT.getText()));
                int answer = num1/num2;
                out.setText(String.valueOf(answer));
            }
        });
        mulBTN.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(n1TXT.getText()));
                int num2 = Integer.parseInt(String.valueOf(n2TXT.getText()));
                int answer = num1*num2;
                out.setText(String.valueOf(answer));
            }
        });

    }
    public void test(View v){

        String input = String.valueOf(n1TXT.getText());
        out.setText(input);
    }
    //these are for hard coding the onClick
    public void add(View v){
        int num1 = Integer.parseInt(String.valueOf(n1TXT.getText()));
        int num2 = Integer.parseInt(String.valueOf(n2TXT.getText()));
        int answer = num1+num2;
        out.setText(String.valueOf(answer));
    }
    public void subtract(View v){
        int num1 = Integer.parseInt(String.valueOf(n1TXT.getText()));
        int num2 = Integer.parseInt(String.valueOf(n2TXT.getText()));
        int answer = num1-num2;
        out.setText(String.valueOf(answer));
    }

}
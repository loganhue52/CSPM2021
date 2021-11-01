package com.example.pizzaplanet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private RadioGroup sizeRG;
    private RadioButton smallRB;
    private RadioButton medRB;
    private RadioButton lgRB;

    private TextView output;

    private CheckBox pepCB;
    private CheckBox hamCB;
    private CheckBox sausageCB;
    private CheckBox ancCB;
    private CheckBox bacCB;
    private CheckBox jalCB;

    private Button outputBTN;

    double total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeRG = findViewById(R.id.sizeRG);
        smallRB=findViewById(R.id.smallRB);
        medRB=findViewById(R.id.medRB);
        lgRB=findViewById(R.id.lgRB);
        output=findViewById(R.id.outputTXT);
        pepCB=findViewById(R.id.pepperoniCB);
        hamCB=findViewById(R.id.hamCB);
        sausageCB=findViewById(R.id.sausageCB);
        ancCB=findViewById(R.id.anchoviesCB);
        bacCB=findViewById(R.id.baconCB);
        jalCB=findViewById(R.id.jalaCB);
        outputBTN=findViewById(R.id.outputBTN);



        outputBTN.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if(ancCB.isChecked()){
                    //Toast.makeText(MainActivity.this,"anchovies",Toast.LENGTH_SHORT).show();
                    total+=0.99;
                }
                if(bacCB.isChecked()){
                    total+=0.99;
                }
                if(jalCB.isChecked()){
                    total+=0.99;
                }
                if (pepCB.isChecked()){
                    total+=0.99;
                }
                if (hamCB.isChecked()){
                    total+=0.99;
                }
                if (sausageCB.isChecked()){
                    total+=0.99;
                }

                output.setText(Double.toString((double) Math.round(total*100)/100));
                onRadioButtonClicked();
            }
        });
        sizeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton rB = (RadioButton) sizeRG.findViewById(id);
            }
        });
    }
    public void onRadioButtonClicked(){
        Log.d("Radiobutton test","triggered");
        //when no radio button is selected, it returns -1

        int selectedId = sizeRG.getCheckedRadioButtonId();

        if(selectedId == -1){
            Toast.makeText(MainActivity.this,"Please choose a size!",Toast.LENGTH_SHORT).show();
        } else {
            RadioButton radioButton = (RadioButton) sizeRG.findViewById(selectedId);
            if (radioButton.getText().equals("Small")){
                total+=6.99;
            } else if (radioButton.getText().equals("Medium")){
                total+=9.99;
            } else {
                total+=12.99;
            }
        }
    }
}
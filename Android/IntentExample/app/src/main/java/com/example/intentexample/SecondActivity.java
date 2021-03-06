package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button closeBTN;
    private TextView secondLBL;
    private EditText secondUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        closeBTN = findViewById(R.id.closeBTN);
        secondLBL = findViewById(R.id.secondLBL);
        secondUI = findViewById(R.id.secondUI);

        String valueOfIntent = getIntent().getStringExtra("input");
        secondLBL.setText(valueOfIntent);

        closeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ui = String.valueOf(secondUI.getText());
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtra("input",valueOfIntent);
                i.putExtra("input2",ui);
                startActivity(i);
            }
        });
    }
}
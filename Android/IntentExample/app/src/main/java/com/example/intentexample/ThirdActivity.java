package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private Button thirdBTN;
    private TextView thirdLBL1;
    private TextView thirdLBL2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        thirdBTN = findViewById(R.id.thirdBTN);
        thirdLBL1 = findViewById(R.id.thirdLBL1);
        thirdLBL2 = findViewById(R.id.thirdLBL2);

        String valueOfIntent1 = getIntent().getStringExtra("input");
        String valueOfIntent2 = getIntent().getStringExtra("input2");
        thirdLBL1.setText(valueOfIntent1);
        thirdLBL2.setText(valueOfIntent2);

        thirdBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
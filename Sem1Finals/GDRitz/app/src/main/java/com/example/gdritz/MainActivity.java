package com.example.gdritz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button openBTN;
//    private EditText firstUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openBTN = findViewById(R.id.openBTN);
//        firstUI = findViewById(R.id.firstUI);

        openBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String ui = String.valueOf(firstUI.getText());
                Intent i = new Intent(MainActivity.this,ComboActivity.class);
//                i.putExtra("input",ui);
                startActivity(i);
            }
        });
    }
}
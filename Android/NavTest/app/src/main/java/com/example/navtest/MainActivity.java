package com.example.navtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button imgBTN;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBTN=findViewById(R.id.imgBTN);
        image=findViewById(R.id.imageView);
        imgBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                graphicMap();
            }
        });
    }

    private void graphicMap(){

        image.setImageResource(R.drawable.two);

    }
}
package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /*
            Getting info from Intent:
                //variable = getIntentData.getStringData("key name you used")
                String name = getIntent().getStringExtra("name");

         */
        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);

        nameTextView = findViewById(R.id.pokemonName);
        numberTextView = findViewById(R.id.pokemonNumber);

        nameTextView.setText("Pokemon name: "+name);
        numberTextView.setText("Pokemon number: "+number);

    }
}
package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView typeTextView;

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
        String type = getIntent().getStringExtra("type");

        nameTextView = findViewById(R.id.pokemonName);
        numberTextView = findViewById(R.id.pokemonNumber);
        typeTextView = findViewById(R.id.typeTextView);


        nameTextView.setText("Pokemon name: "+name);
        numberTextView.setText("Pokemon number: "+number);
        typeTextView.setText("Pokemon Type: "+type);

    }
}
package com.example.gdritz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ComboActivity extends AppCompatActivity {
    //Side Button
    private Button iceCreamBTN;
    private Button comboBTN;
    private Button sandwichBTN;
    private Button hotDogsBTN;
    private Button chiliBTN;
    private Button specialBTN;
    private Button saladBTN;
    private Button checkoutBTN;

    // Order Buttons
    private Button oneBTN;
    private Button twoBTN;
    private Button threeBTN;
    private Button fourBTN;
    private Button fiveBTN;
    private Button sixBTN;
    private Button sevenBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.combo_activity);

        //Side Button
        iceCreamBTN = findViewById(R.id.iceCreamBTN);
        comboBTN = findViewById(R.id.combosBTN);
        sandwichBTN = findViewById(R.id.sandwichBTN);
        hotDogsBTN = findViewById(R.id.hotDogsBTN);
        chiliBTN = findViewById(R.id.chiliBTN);
        specialBTN = findViewById(R.id.specialBTN);
        saladBTN = findViewById(R.id.saladBTN);
        checkoutBTN = findViewById(R.id.checkOutBTN);

        // Order Button
        oneBTN = findViewById(R.id.oneBTN);
        twoBTN = findViewById(R.id.twoBTN);
        threeBTN = findViewById(R.id.threeBTN);
        fourBTN = findViewById(R.id.fourBTN);
        fiveBTN = findViewById(R.id.fiveBTN);
        sixBTN = findViewById(R.id.sixBTN);
        sevenBTN = findViewById(R.id.sevenBTN);


        //Side buttons
        iceCreamBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(SandwichActivity.this,IceCreamActivity.class);
                //startActivity(i);
            }
        });
        comboBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(ChilliActivity.this,ComboActivity.class);
//                startActivity(i);
                Toast.makeText(getApplicationContext(), "You're already on the Combo Menu!", Toast.LENGTH_SHORT).show();
            }
        });
        sandwichBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(SandwichActivity.this,SandwichActivity.class);
//                startActivity(i);
            }
        });
        hotDogsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(SandwichActivity.this,HotDogsActivity.class);
                //startActivity(i);
            }
        });
        chiliBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComboActivity.this,ChilliActivity.class);
                startActivity(i);
            }
        });
        specialBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(SandwichActivity.this,SpecialActivity.class);
                //startActivity(i);
            }
        });
        saladBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(SandwichActivity.this,SaladActivity.class);
//                startActivity(i);
            }
        });
        checkoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ComboActivity.this,CheckoutActivity.class);
                startActivity(i);
            }
        });

        // Order Button
        oneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        twoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        threeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fourBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        fiveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sixBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sevenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
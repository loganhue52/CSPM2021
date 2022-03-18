package com.example.triptracker;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class TripActivity extends AppCompatActivity {
    private EditText mNameField,mDescriptionField;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        mNameField=findViewById(R.id.enter_trip_name);
        mDescriptionField=findViewById(R.id.enter_trip_description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trip_details,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.home:
                return true;
            case R.id.action_post:
                updateTrip(item);
                return true;
            case R.id.action_logout:
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_delete:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateTrip(MenuItem item) {
        String name,desc;

        //get info from xml
        name=mNameField.getText().toString().trim();
        desc=mDescriptionField.getText().toString().trim();

        //verify name isnt blank
        Trip t = new Trip(name,desc);
        Log.d("create trip: ",t.toString());

        //push
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                //connect and push to FB

            }
        });

        th.start();

        //join with main thread
        try{
            th.join();
            Log.d("Update: ","Thread joined.");
            Toast.makeText(TripActivity.this,"Post saved",Toast.LENGTH_SHORT).show();
        }catch(InterruptedException e){
            Toast.makeText(TripActivity.this,(CharSequence) e,Toast.LENGTH_SHORT).show();
        }

    }
}

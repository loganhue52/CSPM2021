package com.example.triptracker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        Log.d("create trip ",name);
        //push
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                rootRef= FirebaseDatabase.getInstance().getReference("Trip");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Log.d("UpdateTripThread","New trip");
                        rootRef.push().setValue(t);
//                        startActivity(new Intent(TripActivity.this,StreamActivity.class));
                        //we can do something else in here
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("UpdateTripThread",String.valueOf(error));
                    }
                });

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

package com.example.triptracker;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
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
    private TextView mIdText;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        mNameField=findViewById(R.id.enter_trip_name);
        mDescriptionField=findViewById(R.id.enter_trip_description);
        mIdText=findViewById(R.id.testTXT);

        String tripName = getIntent().getStringExtra("name");
        String tripDesc = getIntent().getStringExtra("desc");
        String tripId = getIntent().getStringExtra("id");

        mNameField.setText(tripName);
        mDescriptionField.setText(tripDesc);
        mIdText.setText(tripId);
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
        String name,desc,id;

        //get info from xml
        name=mNameField.getText().toString().trim();
        desc=mDescriptionField.getText().toString().trim();
        //Never pull from the widget
        id = mIdText.getText().toString().trim();

        //verify name isnt blank
        Trip t = new Trip(id,name,desc);
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
                        //check to see if its already there
                        boolean tripExists = false;
                        String key="";
                        for(DataSnapshot ds: snapshot.getChildren()){
                            key=ds.getKey();
                            if(key.equals(t.getObjectId())){
                                tripExists=true;
                                break;
                            }
                        }
                        if(tripExists){
                            Log.d("UpdateTrip",t.getObjectId()+" already there");
                            rootRef = FirebaseDatabase.getInstance().getReference("Trip/"+key);
                            rootRef.setValue(t);
                        }else {
                            //if not
                            Log.d("UpdateTripThread", "New trip");
                            rootRef.push().setValue(t);
                            rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    String key = "";
                                    for(DataSnapshot ds: snapshot.getChildren()){
                                        key=ds.getKey();
                                        Log.d("UpdateTrip","New key "+key);
                                    }
                                    t.setObjectId(key);
                                    String path = "Trip/"+key;
                                    rootRef = FirebaseDatabase.getInstance().getReference(path);
                                    rootRef.setValue(t);
                                    mIdText.setText(t.getObjectId());
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
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
            startActivity(new Intent(TripActivity.this, StreamActivity.class));
        }catch(InterruptedException e){
            Toast.makeText(TripActivity.this,(CharSequence) e,Toast.LENGTH_SHORT).show();
        }

    }
}

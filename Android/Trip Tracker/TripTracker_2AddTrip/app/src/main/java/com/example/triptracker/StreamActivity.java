package com.example.triptracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class StreamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_trip_list_item_context,menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_trips,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //where the menu items actions will be
        switch(item.getItemId()){
            //log that each are clicked
            case R.id.action_new:
                Log.d("action_new: ","clicked");
                //open the TripActivity file
                startActivity(new Intent(StreamActivity.this,TripActivity.class));
                return true;
            case R.id.action_public_trips:
                Log.d("action_public_trips: ","clicked");
                return true;
            case R.id.action_my_trips:
                Log.d("action_my_trips: ","clicked");
                return true;
            case R.id.action_logout:
                Log.d("action_logout: ","clicked");
                return true;
            case R.id.action_settings:
                Log.d("action_settings: ","clicked");
                return true;
            case R.id.action_refresh:
                Log.d("action_refresh: ","clicked");
                return true;
            case R.id.action_search:
                Log.d("action_search: ","clicked");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
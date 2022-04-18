package com.example.triptracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class StreamActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private static TripAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static boolean mPublicView = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        setTitle("Stream");

        mPublicView=getIntent().getBooleanExtra(Trip.EXTRA_TRIP_PUBLIC_VIEW,true);

        recyclerView=findViewById(R.id.recycler_view);
        adapter=new TripAdapter(getApplicationContext());
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



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
        Intent i;
        switch(item.getItemId()){
            //log that each are clicked
            case R.id.action_new:
                Log.d("action_new: ","clicked");
                //open the TripActivity file
                startActivity(new Intent(StreamActivity.this,TripActivity.class));
                return true;
            case R.id.action_public_trips:
                Log.d("action_public_trips: ","clicked");
                i = new Intent(getApplicationContext(),StreamActivity.class);
                i.putExtra(Trip.EXTRA_TRIP_PUBLIC_VIEW,true);
                startActivity(i);
                return true;
            case R.id.action_my_trips:
                Log.d("action_my_trips: ","clicked");
                i = new Intent(getApplicationContext(),StreamActivity.class);
                i.putExtra(Trip.EXTRA_TRIP_PUBLIC_VIEW,false);
                startActivity(i);
                return true;
            case R.id.action_logout:
                Log.d("action_logout: ","clicked");
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(StreamActivity.this,LoginActivity.class));
                return true;
            case R.id.action_settings:
                Log.d("action_settings: ","clicked");
                return true;
            case R.id.action_refresh:
                Log.d("action_refresh: ","clicked");
                //adapter.notifyDataSetChanged(); //tells adapter that data has changed
                refreshStream();
                return true;
            case R.id.action_search:
                Log.d("action_search: ","clicked");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mPublicView){
            menu.findItem(R.id.action_public_trips).setVisible(false);
            menu.findItem(R.id.action_my_trips).setVisible(true);
        }else{
            menu.findItem(R.id.action_public_trips).setVisible(true);
            menu.findItem(R.id.action_my_trips).setVisible(false);
        }
        return true;
    }

    public static void refreshPage(){
        adapter.notifyDataSetChanged();
    }
    private void refreshStream(){
        adapter=new TripAdapter(getApplicationContext());
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.notifyDataSetChanged();
    }
}
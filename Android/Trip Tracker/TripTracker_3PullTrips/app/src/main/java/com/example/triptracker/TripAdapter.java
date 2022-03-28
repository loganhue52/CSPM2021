package com.example.triptracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> listOfTrips = new ArrayList<>();
    private DatabaseReference demoRef;

    public TripAdapter(Context context){
        Log.d("Pulling","new Adapter");
        loadTrips();
    }

    private void loadTrips() {
        //clear out the listOfTrips
        listOfTrips.clear();
        //take a snapshot of the db and loop through it
        demoRef = FirebaseDatabase.getInstance().getReference().child("Trip");
        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //loop through snapshot
                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = ds.child("name").getValue(String.class);
                    String desc = ds.child("desc").getValue(String.class);
                    Trip t = new Trip(name,desc);
                    listOfTrips.add(t);
                    Log.d("Pull",t.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("TripAdapter","Error loading trips");
            }
        });
    }

    @NonNull
    @Override
    public TripAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_card,parent,false);
        return new TripViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.TripViewHolder holder, int position) {
        Trip current = listOfTrips.get(position);
        holder.textView.setText(current.getName());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return listOfTrips.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            containerView = itemView.findViewById(R.id.trip_card_layout);
            textView = itemView.findViewById(R.id.trip_card_name);
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Trip current = (Trip) containerView.getTag();
                    Intent i = new Intent(view.getContext(),TripActivity.class);
                    i.putExtra("name",current.getName());
                    i.putExtra("description",current.getDesc());
                    view.getContext().startActivity(i);
                }
            });
        }
    }
}

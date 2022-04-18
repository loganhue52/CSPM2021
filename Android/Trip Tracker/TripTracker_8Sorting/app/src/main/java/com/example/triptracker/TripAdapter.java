package com.example.triptracker;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    private List<Trip> listOfTrips = new ArrayList<>();
    private DatabaseReference rootRef;
    private boolean publicTripView = Boolean.valueOf(StreamActivity.mPublicView);
    private String currentUID = FirebaseAuth.getInstance().getUid();
    private String tripId;
//    private String UID = FirebaseAuth.getInstance().getUid();

    public TripAdapter(Context context){
        Log.d("Pulling","new Adapter");
        loadTrips();
    }

    private void loadTrips() {
        //clear out the listOfTrips
        listOfTrips.clear();
        //take a snapshot of the db and loop through it
        rootRef = FirebaseDatabase.getInstance().getReference().child("Trip");
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //loop through snapshot
                for(DataSnapshot ds: snapshot.getChildren()){
                    String name = ds.child("name").getValue(String.class);
                    String desc = ds.child("desc").getValue(String.class);
                    String id = ds.child("objectId").getValue(String.class);
                    boolean shared=ds.child("shared").getValue(Boolean.class);
                    String UID = ds.child("uid").getValue(String.class);
                    Trip t = new Trip(id,name,desc,shared,UID);
                    //public
                    if(publicTripView){
                        if (shared) {
                            listOfTrips.add(t);
                        }
                    }else{ //private
                        if ((!shared) && (t.getUID().equals(currentUID))) {
                            listOfTrips.add(t);
                        }
                    }
//                    listOfTrips.add(t);
                    Log.d("Pull",t.toString());
                }
                StreamActivity.refreshPage();
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
        holder.name.setText(current.getName());
        holder.desc.setText(current.getDesc());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return listOfTrips.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout containerView;
        public TextView name;
        public TextView desc;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            containerView = itemView.findViewById(R.id.trip_card_layout);
            name = itemView.findViewById(R.id.trip_card_name);
            desc = itemView.findViewById(R.id.trip_card_desc);
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Trip current = (Trip) containerView.getTag();
                    Intent i = new Intent(view.getContext(),TripActivity.class);
                    i.putExtra("name",current.getName());
                    i.putExtra("desc",current.getDesc());
                    i.putExtra("id",current.getObjectId());
                    i.putExtra("shared",current.isShared());
                    i.putExtra("uid",current.getUID());
                    view.getContext().startActivity(i);
                }
            });
            containerView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    PopupMenu pop = new PopupMenu(containerView.getContext(),itemView);
                    pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            Trip current = (Trip) containerView.getTag();
                            tripId= current.getObjectId();
                            switch (menuItem.getItemId()){
                                case(R.id.menu_item_delete_trip):
//                                    Toast.makeText(containerView.getContext(), "Delete",Toast.LENGTH_SHORT).show();
                                    deleteTrip(menuItem);
                                    StreamActivity.refreshPage();
                                    loadTrips();
                                    return true;
                            }
                            return false;
                        }
                    });
                    pop.inflate(R.menu.menu_trip_list_item_context);
                    pop.show();
                    return false;
                }
            });
        }
    }
    private void deleteTrip(MenuItem item){
        Log.d("TripActivityDelete","start");
        rootRef = FirebaseDatabase.getInstance().getReference("Trip");
        //build thread
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                Query q = rootRef.child(tripId);
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        snapshot.getRef().removeValue();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
//                        mIdText.setText("Delete error..."+error);
                    }
                });
            }
        });
        //start the thread
        th.start();
        //merge back to main application
        try{
            th.join();
            StreamActivity.refreshPage();

        } catch (InterruptedException e){
//            Toast.makeText(getCon,"Error removig: "+e,Toast.LENGTH_SHORT).show();
        }
    }
}

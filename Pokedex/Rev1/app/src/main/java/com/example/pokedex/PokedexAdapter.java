package com.example.pokedex;

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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//PokedexAdapter -> an adapter to conver multiple layouts into one single list
public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>{


    private List<Pokemon> thePokemonList = new ArrayList<>();
    private RequestQueue requestQueue;

    //Class that populates and builds each individual card

    public class PokedexViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout containerView;
        public TextView textView;
        public PokedexViewHolder(@NonNull View itemView) {
            super(itemView);

            //containerView is each card we see
            containerView = itemView.findViewById(R.id.pokedex_card);
            //textView is the information in each card
            textView = itemView.findViewById(R.id.pokedex_card_txt);
            //making the cards do something when clicked
            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //find out which Pokemon we clicked on by casting it from a containerView's Tag
                    Pokemon pokemonThatWeClickedOn = (Pokemon) containerView.getTag();
                    Log.d("Container OnClick",pokemonThatWeClickedOn.getName());
                    Intent intent = new Intent(view.getContext(),DetailsActivity.class);
                    //'key','value'
                    intent.putExtra("name",pokemonThatWeClickedOn.getName());
                    intent.putExtra("number",pokemonThatWeClickedOn.getNumber());
                    intent.putExtra("url",pokemonThatWeClickedOn.getUrl());
//                    intent.putExtra("t1",pokemonThatWeClickedOn.getT1());
//                    intent.putExtra("t2",pokemonThatWeClickedOn.getT2());

                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    //pokedex adapter constructor
    PokedexAdapter(Context c){
        Log.d("PokedexAdapter","new PokedexAdapter");

        requestQueue = Volley.newRequestQueue(c);
        loadPokemon();
    }

    @NonNull
    @Override
    //one of the first methods to run -> onCreate
    //create the view (cards) that we see on the screen
    //Discord:  This method loads each post you see in the conversation
    public PokedexAdapter.PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //viewobject = Call the LayoutInflater from where we're currently at and inflate a pokedex_card in the parent, and don't attached

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_card,parent,false);
        return new PokedexViewHolder(view);
    }

    @Override

    //tells what each row will have in its widgets
    //set the different onclick information
    //keyBindings from Turtle and Tkinter
    //any time you click on a card, this is where you pull the information from the card

    public void onBindViewHolder(@NonNull PokedexAdapter.PokedexViewHolder holder, int position) {
        Pokemon pokemonThatWeClickedOn = thePokemonList.get(position);
        holder.textView.setText(pokemonThatWeClickedOn.getName());
        holder.containerView.setTag(pokemonThatWeClickedOn);
    }

    @Override
    //tells the adapter how long it needs to be or what size the recycler view needs to be
    public int getItemCount() {
        return thePokemonList.size();
    }

    //creates request and shred the data when it comes back
    public void loadPokemon(){
        //set up url
        String url = "https://pokeapi.co/api/v2/pokemon?limit=151";
        //build request
        //new JsonObjectRequest(web method as in getting or setting info,
        //                      url it is sent to,
        //                      listener as data we are sending,
        //                      the methods to happen after the request - onResponse - onError...);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //if request is 200 (good), add pokemon to thePokemonList
                try{
                    JSONArray results = response.getJSONArray("results"); //getJSONArray("name of the array in the data");
                    //loop through the data and add it to our RecyclerView or Stream
                    for(int i=0;i<results.length();i++){
                        JSONObject r = results.getJSONObject(i);
                        String name = r.getString("name");
                        String url = r.getString("url");
                        //create and add pokemon to thePokemonList
                        thePokemonList.add(new Pokemon(name,url));
                    }
                    //update RecyclerView
                    notifyDataSetChanged();
                }catch(JSONException e){
                    Log.e("Adapter LoadPokemon","Json error",e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //if request is 404 (doesn't exist), give a warning
                Log.e("PokeAPI Pull","Pokemon API:"+error);
            }
        });

        //add request to the queue
        requestQueue.add(request);
    }

}

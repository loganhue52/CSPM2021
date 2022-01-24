package com.example.pokedex;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.List;

//PokedexAdapter -> an adapter to conver multiple layouts into one single list
public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>{

    private List<Pokemon> thePokemonList = Arrays.asList(
            new Pokemon("Bulbasaur",1),
            new Pokemon("Ivysaur",2),
            new Pokemon("Venusaur",3)
    );

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
                    view.getContext().startActivity(intent);
                }
            });
        }
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


}

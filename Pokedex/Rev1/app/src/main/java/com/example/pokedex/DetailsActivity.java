package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    public String name;
    private TextView numberTextView;
    private TextView urlTextView;
    private TextView t1TextView;
    private TextView t2TextView;
    private RequestQueue requestQueue;
    private TextView movesTextView;
    public String moveString;
    public String number;
    private Button catchBTN;
    public boolean doIHavePokemon;
    public SharedPreferences sharedPref;
    public boolean defaultValue;
    public SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        /*
            Getting info from Intent:
                //variable = getIntentData.getStringData("key name you used")
                String name = getIntent().getStringExtra("name");

         */
//        String name = getIntent().getStringExtra("name");
//        int number = getIntent().getIntExtra("number",0);
        String url = getIntent().getStringExtra("url");
//        String t1 = getIntent().getStringExtra("t1");
//        String t2 = getIntent().getStringExtra("t2");

        nameTextView = findViewById(R.id.pokemonName);
        numberTextView = findViewById(R.id.pokemonNum);
        urlTextView = findViewById(R.id.pokemonURL);
        t1TextView = findViewById(R.id.pokemonType1);
        t2TextView = findViewById(R.id.pokemonType2);
        movesTextView = findViewById(R.id.pokemonMoves);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        catchBTN = findViewById(R.id.catchBTN);
        name=getIntent().getStringExtra("name");

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPref.edit();

        load(url);

        Log.e("contains pokemon",""+sharedPref.contains(name));

        if (sharedPref.contains(name)){
            doIHavePokemon=true;
            catchBTN.setText("Release");
        }else{
            doIHavePokemon=false;
            catchBTN.setText("Catch");
        }

        catchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCatch(view);
            }
        });

    }

    public void load(String url) {
        t2TextView.setText("");

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray typeEntries = response.getJSONArray("types");
                    for (int i = 0; i < typeEntries.length(); i++) {
                        JSONObject typeEntry = typeEntries.getJSONObject(i);
                        int slot = typeEntry.getInt("slot");
                        String type = typeEntry.getJSONObject("type").getString("name");
                        //if 2 slots or not
                        if (slot == 1) {
                            t1TextView.setText(type);
                        } else {
                            t2TextView.setText(type);
                        }
                    }

                    JSONArray moveEntries = response.getJSONArray("moves");
                    for (int i = 0; i < moveEntries.length(); i++) {
                        JSONObject moveEntry = moveEntries.getJSONObject(i);
                        String move = moveEntry.getJSONObject("move").getString("name");
                        moveString += (move + "\n");
                    }
//                    Log.e("name",""+response.getString("name"));
                    name = response.getString("name");

                    number = response.getString("id");

                    nameTextView.setText("Pokemon name: " + name);
                    numberTextView.setText("Pokemon number: " + number);
                    urlTextView.setText("URL: " + url);
                    movesTextView.setText(moveString);

                } catch (JSONException e) {
                    Log.e("Details getTypeEntries", "Json error", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("PokeAPI Pull", "Pokemon API:" + error);
            }
        });

        requestQueue.add(request);

    }
    public void toggleCatch(View view){
        //gotto catch them all
        if (doIHavePokemon == false){
            catchBTN.setText("Caught");
            doIHavePokemon = true;
            editor.putBoolean(name,true);
            editor.commit();
        }
        else if(doIHavePokemon == true){
            catchBTN.setText("Released");
            doIHavePokemon = false;
            editor.remove(name);
            editor.commit();
        }
    }
}
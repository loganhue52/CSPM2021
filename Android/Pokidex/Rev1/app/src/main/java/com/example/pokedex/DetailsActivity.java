package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;
    private TextView urlTextView;
    private TextView t1TextView;
    private TextView t2TextView;
    private RequestQueue requestQueue;
    private TextView movesTextView;
    public String moveString;

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
        numberTextView = findViewById(R.id.pokemonNumber);
        urlTextView = findViewById(R.id.pokemonURL);
        t1TextView = findViewById(R.id.pokemonT1);
        t2TextView = findViewById(R.id.pokemonT2);
        movesTextView = findViewById(R.id.movesTextView);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        load(url);

    }

    public void load(String url){
        t2TextView.setText("");
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    //get types
                    JSONArray typeEntries = response.getJSONArray("types");
                    for(int i=0;i<typeEntries.length();i++){
                        JSONObject typeEntry = typeEntries.getJSONObject(i);
                        int slot = typeEntry.getInt("slot");
                        String type = typeEntry.getJSONObject("type").getString("name");
                        //if 2 slots or not
                        if (slot==1){
                            t1TextView.setText(type);
                        }else{
                            t2TextView.setText(type);
                        }
                    }

                    JSONArray moveEntries = response.getJSONArray("moves");
                    for (int i=0;i<moveEntries.length();i++){
                        JSONObject moveEntry = moveEntries.getJSONObject(i);
                        String move = moveEntry.getJSONObject("move").getString("name");
                        moveString+=(move+"\n");
                    }

                    String name = response.getString("name");

                    String number = response.getString("id");

                    nameTextView.setText("Pokemon name: "+name);
                    numberTextView.setText("Pokemon number: "+number);
                    urlTextView.setText("URL: "+url);
                    movesTextView.setText(moveString);

                }catch(JSONException e){
                    Log.e("Details getTypeEntries","Json error",e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("PokeAPI Pull","Pokemon API:"+error);
            }
        });
        requestQueue.add(request);


    }
}
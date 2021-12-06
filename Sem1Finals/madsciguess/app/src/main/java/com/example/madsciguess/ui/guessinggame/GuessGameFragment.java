package com.example.madsciguess.ui.guessinggame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madsciguess.MainActivity;
import com.example.madsciguess.R;
import java.util.Random;

public class GuessGameFragment extends Fragment {
    //initialize variables
    SeekBar input;
    TextView pointTXT;
    TextView livesTXT;
    TextView numTXT;
//    EditText input;
    //public variables to use anywhere in any method
    public int points=0;
    public int lives=5;
    public int rnum = new Random().nextInt(100)+1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guess_game,container,false);
//        enterBTN=rootView.findViewById(R.id.enterBTN);
        //finding all of the elements
        input=rootView.findViewById(R.id.input);
        pointTXT=rootView.findViewById(R.id.pointTXT);
        livesTXT=rootView.findViewById(R.id.livesTXT);
        numTXT=rootView.findViewById(R.id.numTXT);
        //running reset to make sure values are shown
        reset();
        input.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //making a vale variable to pass into my check function
            int value=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                value=i;
                //live action text to sow what number the user lands on
                numTXT.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                guessCheck(value);
            }
        });
        return rootView;
    }
    public void reset(){
        //resetting values to default
        points=0;
        lives=5;
        pointTXT.setText("Points: "+points);
        livesTXT.setText("Lives: "+lives);
        rnum = new Random().nextInt(100)+1;
    }
    private void guessCheck(int uIn){
        //old code from when it was a EditText input
//        int uIn = Integer.parseInt(input.getText().toString());
        //if the user input = the random number
        if (uIn==rnum){
            //tell the user they were right
            Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
            //generate a new number, add points, and update the text views
            rnum = new Random().nextInt(100)+1;
            points+=50;
            points+=(lives*5);
            lives=5;
            pointTXT.setText("Points: "+points);
            livesTXT.setText("Lives: "+lives);
        } else{
            //remove a life
            lives-=1;
            //if the lives are zero, tell the user they lost and reset the game
            if (lives==0){
                Toast.makeText(getActivity(), "You Lost! Correct # was "+rnum, Toast.LENGTH_SHORT).show();
                reset();
                //if they havent run out of lives
            } else{
                //update lives text view
                livesTXT.setText("Lives: " + lives);
                //if the user guessed lower, tell them go higher and vice versa
                if (uIn<rnum) {
                    Toast.makeText(getActivity(), "Incorrect! Go Higher!", Toast.LENGTH_SHORT).show();
                } else if (uIn > rnum){
                    Toast.makeText(getActivity(), "Incorrect! Go Lower!", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

}
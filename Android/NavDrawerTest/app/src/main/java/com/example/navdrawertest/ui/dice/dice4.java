package com.example.navdrawertest.ui.dice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.navdrawertest.R;

import java.util.Random;

public class dice4 extends Fragment {

    private ImageView dice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_dice,container,false);

        //findviewbyid is a method of the View class
        dice = rootView.findViewById(R.id.diceimg);
        dice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                rollDice();
            }
        });

        return rootView;
    }
    private void rollDice(){
        //random num 1-6
        Random rand = new Random();
        int num = rand.nextInt(4);

        switch (num){
            case 0:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 1:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice3);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice4);
                break;
        }

    }
}
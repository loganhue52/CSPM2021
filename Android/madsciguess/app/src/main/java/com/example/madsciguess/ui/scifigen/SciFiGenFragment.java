package com.example.madsciguess.ui.scifigen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.madsciguess.R;

public class SciFiGenFragment extends Fragment {
    EditText firstTXT;
    EditText lastTXT;
    EditText cityTXT;
    EditText schoolTXT;
    EditText broTXT;
    EditText sisTXT;
    Button genBTN;
    TextView output;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sci_fi_gen,container,false);
        firstTXT = rootView.findViewById(R.id.firstTXT);
        lastTXT = rootView.findViewById(R.id.lastTXT);
        cityTXT = rootView.findViewById(R.id.cityTXT);
        schoolTXT = rootView.findViewById(R.id.schoolTXT);
        broTXT = rootView.findViewById(R.id.broTXT);
        sisTXT = rootView.findViewById(R.id.sisTXT);
        output = rootView.findViewById(R.id.output);
        genBTN = rootView.findViewById(R.id.genBTN);

        //utilize an onClickListener to lsiten for the button
        genBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                generate();
            }

        });
        // Inflate the layout for this fragment
        return rootView;
    }
    private void generate(){
        String first = String.valueOf(firstTXT.getText());
        String last = String.valueOf(lastTXT.getText());
        String city = String.valueOf(cityTXT.getText());
        String school = String.valueOf(schoolTXT.getText());
        String bro = String.valueOf(broTXT.getText());
        String sis = String.valueOf(sisTXT.getText());

        int rF = (int) (Math.random()*first.length());
        int rL = (int) (Math.random()*last.length());
        int rC = (int) (Math.random()*city.length());
        int rS = (int) (Math.random()*school.length());
        int rB = (int) (Math.random()*bro.length());
        int rSi = (int) (Math.random()*sis.length());

        String sciFiFirst = first.substring(0,rF)+last.substring(rL);
        String sciFiLast = city.substring(0,rC)+school.substring(rS);
        String sciFiHome = bro.substring(rB)+sis.substring(0,rSi);

        output.setText(String.format("Welcome %s %s from %s",sciFiFirst,sciFiLast,sciFiHome));
    }
}
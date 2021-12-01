package com.example.seekerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView message;
    SeekBar r;
    SeekBar g;
    SeekBar b;
    TextView ct;
//    TextView gt;
//    TextView bt;
    ConstraintLayout screen;
    public int rVal=255;
    public int gVal=255;
    public int bVal=255;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link java to widget
//        message = findViewById(R.id.textView);
        r = findViewById(R.id.red);
        g = findViewById(R.id.green);
        b = findViewById(R.id.blue);
        ct = findViewById(R.id.ctext);
        screen = findViewById(R.id.screen);

        //screen.setBackgroundColor(0xFF00FF00);

        ct.setText("RGB: "+rVal+","+gVal+","+bVal);
//        gt.setText("Green: "+g.getProgress()+"/"+g.getMax());
//        bt.setText("Blue: "+b.getProgress()+"/"+b.getMax());

        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int val = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //when sliding
//                message.setTextSize(i+1);
//                rt.setText("Red: "+i+"/"+r.getMax());
                rVal=i;
                updateColor();
//                screen.setBackgroundColor(Color.rgb(rVal,gVal,bVal));
//                screen.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(rVal)+Integer.toHexString(gVal)+Integer.toHexString(bVal)));
//                screen.setBackgroundColor(0xFF+Integer.parseInt(Integer.toHexString(rVal))+Integer.parseInt(Integer.toHexString(gVal))+Integer.parseInt(Integer.toHexString(bVal)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //on touch
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //on release

            }
        });
        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int val = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //when sliding
//                message.setTextSize(i+1);
//                gt.setText("Green: "+i+"/"+g.getMax());
//                bt.setText(Integer.toHexString(gVal));
                gVal=i;
                updateColor();
//                screen.setBackgroundColor(0xFF+Integer.parseInt(Integer.toHexString(rVal))+Integer.parseInt(Integer.toHexString(gVal))+Integer.parseInt(Integer.toHexString(bVal)));
//                screen.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(rVal)+Integer.toHexString(gVal)+Integer.toHexString(bVal)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //on touch
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //on release

            }
        });
        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean bool) {
                //when sliding
//                message.setTextSize(i+1);
//                bt.setText("Blue: "+i+"/"+b.getMax());
                bVal=i;
                updateColor();
//                screen.setBackgroundColor(0xFF+Integer.parseInt(Integer.toHexString(rVal))+Integer.parseInt(Integer.toHexString(gVal))+Integer.parseInt(Integer.toHexString(bVal)));
//                screen.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(rVal)+Integer.toHexString(gVal)+Integer.toHexString(bVal)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //on touch
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //on release
            }
        });
    }
    private void updateColor(){
//        ct.setText("Hex: #"+Integer.toHexString(rVal)+Integer.toHexString(gVal)+Integer.toHexString(bVal));
        ct.setText("RGB: "+rVal+","+gVal+","+bVal);
        screen.setBackgroundColor(Color.rgb(rVal,gVal,bVal));
    }
}
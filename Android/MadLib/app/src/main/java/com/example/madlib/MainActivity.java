package com.example.madlib;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText nounTXT;
    EditText nounTXT2;
    EditText adjTXT;
    EditText adjTXT2;
    EditText verbTXT;
    EditText verbTXT2;
    EditText verbTXT3;
    EditText adverbTXT;
    Button genBTN;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nounTXT = findViewById(R.id.nounTXT);
        nounTXT2 = findViewById(R.id.nounTXT2);
        adjTXT = findViewById(R.id.adjTXT);
        adjTXT2 = findViewById(R.id.adjTXT2);
        verbTXT = findViewById(R.id.verbTXT);
        verbTXT2 = findViewById(R.id.verbTXT2);
        verbTXT3 = findViewById(R.id.verbTXT3);
        adverbTXT = findViewById(R.id.adverbTXT);
        output = findViewById(R.id.output);
        genBTN = findViewById(R.id.genBTN);

        genBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                generate();
            }

        });
    }
    @SuppressLint("DefaultLocale")
    private void generate(){
        String noun1 = String.valueOf(nounTXT.getText());
        String noun2 = String.valueOf(nounTXT2.getText());
        String adj1 = String.valueOf(adjTXT.getText());
        String adj2 = String.valueOf(adjTXT2.getText());
        String verb1 = String.valueOf(verbTXT.getText());
        String verb2 = String.valueOf(verbTXT2.getText());
        String ptverb = String.valueOf(verbTXT3.getText());
        String adverb1 = String.valueOf(adverbTXT.getText());

        String madlib1 = String.format("Say, can you %s " +
                "by the dawn's early %s\n" +
                "What so %s we hailed\n" +
                "At the twilight's last gleaming?\n" +
                "Whose %s stripes and bright stars\n" +
                "Through the perilous fight\n" +
                "O'er the ramparts we %s,\n" +
                "Were so gallantly, yeah, streaming?\n" +
                "And the rockets' red glare\n" +
                "The %s %s in air\n" +
                "Gave proof through the night\n" +
                "That our flag was still there\n" +
                "O say, does that %s-spangled banner yet wave\n" +
                "O'er the land of the free and the home of the brave",verb1,noun1,adverb1,adj1,ptverb,noun2,verb2,adj2);

        String madlib2 = String.format("I woke up to the %s smell\n"+
                "of %s cooking in the kitchen downstairs.\n"+
                "I %s down the stairs to see if I could\n"+
                "%s with the dinner. My Mom said\n"+
                "\"See if your sister needs a fresh %s.\"\n"+
                "So I carried a tray of glasses full\n"+
                "of %s into the dining room.",adj1,noun1,ptverb,verb1,noun2,noun2);

        String madlib3 = String.format("I can believe it's already Halloween!\n"+
                        "I put on my %s and visit every house\n"+
                        "in my neighborhood. Before I %s,\n"+
                        "I make sure to grab my %s %s\n"+
                        "to hold all of my candy.\n"+
                        "Before It got too late, I %s %s\n"+
                        "out of the door and went Trick or Treating!",noun1,verb1,adj1,noun2,adverb1,ptverb);

        Random rn = new Random();
        int choice = rn.nextInt(3) + 1;

        if (choice==1){
            output.setText(madlib1);
        } else if (choice==2){
            output.setText(madlib2);
        } else if (choice==3){
            output.setText(madlib3);
        }


    }
}
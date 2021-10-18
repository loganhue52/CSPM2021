package com.example.madlib;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

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

        String madlib2 = String.format("For breakfast today I had %s.\n"+
                "It was so %s and %s.\n"+
                "After breakfast, I played some %s on my xbox.\n"+
                "I then %s my dog and went a %s.\n"+
                "",noun1,adj1,adj2,noun2,ptverb,verb1);

        output.setText(madlib1);
    }
}
package com.example.dell.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinalScores extends AppCompatActivity {
    TextView teama;
    TextView teamb;
    TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_scores);
        teama=(TextView)findViewById(R.id.textView4);
        teamb=(TextView)findViewById(R.id.textView7);
        winner=(TextView)findViewById(R.id.textView5);
        Bundle b=getIntent().getExtras();
        teama.setText(String.valueOf(b.getInt("team_a")));
        teamb.setText(String.valueOf(b.getInt("team_b")));
        if((b.getInt("team_a")>b.getInt("team_b")))
        {
            winner.setText("TEAM A is the Winner!!!");
        }
        else
        {
            winner.setText("TEAM B is the Winner!!!");
        }
    }

}

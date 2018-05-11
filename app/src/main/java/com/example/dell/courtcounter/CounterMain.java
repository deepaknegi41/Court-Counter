package com.example.dell.courtcounter;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CounterMain extends AppCompatActivity {
    TextView team_a;
    TextView team_b;
    TextView counter;
    TextView score_team_a;
    TextView score_team_b;
    Intent it;
    int score_team_a1;
    int score_team_b1;
    int count_a=0;
    int count_b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_main);
        team_a=(TextView)findViewById(R.id.team_a);
        team_b=(TextView)findViewById(R.id.team_b);
        counter=(TextView)findViewById(R.id.timer);
        score_team_a=(TextView)findViewById(R.id.team_a_score);
        score_team_b=(TextView)findViewById(R.id.team_b_score);
    }
    protected void Points(View v)
    {

        switch(v.getId()) {
            case R.id.point1:
                count_a += 1;
                score_team_a.setText(String.valueOf(count_a));
                break;
            case R.id.point2:
                count_a += 2;
                score_team_a.setText(String.valueOf(count_a));
                break;
            case R.id.point3:
                count_a += 3;
                score_team_a.setText(String.valueOf(count_a));
                break;
            case R.id.bpoint1:
                count_b += 1;
                score_team_b.setText(String.valueOf(count_b));
                break;
            case R.id.bpoint2:
                count_b += 2;
                score_team_b.setText(String.valueOf(count_b));
                break;
            case R.id.bpoint3:
                count_b += 3;
                score_team_b.setText(String.valueOf(count_b));
                break;
            case R.id.start_timer:
                time.start();
                break;
            case R.id.Finish:
                time.onFinish();
                it=new Intent(this,FinalScores.class);
                it.putExtra("team_a",score_team_a1);
                it.putExtra("team_b",score_team_b1);
                startActivity(it);
                break;
            case R.id.Reset:
                time.cancel();
                counter.setText("90:00");
                score_team_a.setText("0");
                score_team_b.setText("0");
                break;
        }
    }

    //String k=(String)counter.getText();
    String k="90:00";
    String time1[]=k.split(":");
    int i=Integer.valueOf(time1[0])*60+Integer.valueOf(time1[1]);


    CountDownTimer time=new CountDownTimer(i*1000,1000) {
        @Override
        public void onTick(long millisUntilFinished)
        {
            long sec=(int)(((millisUntilFinished)%60000)/1000);
            long min=(int)((((millisUntilFinished))/1000)/60);

            String s=String.valueOf(min)+":"+String.valueOf(sec);
            counter.setText(s);
        }

        @Override
        public void onFinish() {
            String s1=(String)score_team_a.getText();
            String s2=(String)score_team_b.getText();
            score_team_a1=Integer.valueOf(s1);
            score_team_b1=Integer.valueOf(s2);
        }
    };

}

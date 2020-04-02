package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    int scr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Bundle b=getIntent().getExtras();
        scr=b.getInt("score",0);
        TextView tv=findViewById(R.id.scoreboard);
        tv.setText(scr+"/10");

        Button b1=findViewById(R.id.bck);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

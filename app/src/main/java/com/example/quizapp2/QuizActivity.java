package com.example.quizapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.quizapp2.Model.QuestionSet;
import com.example.quizapp2.Model.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class QuizActivity extends AppCompatActivity {

    DatabaseReference reference;
    CountDownTimer ct;
    Button b1,b2,b3,b4;
    TextView qs,tt,scr;
    int total=-1;
    public  int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        qs=findViewById(R.id.qsetter);
        b1=findViewById(R.id.option1);
        b2=findViewById(R.id.option2);
        b3=findViewById(R.id.option3);
        b4=findViewById(R.id.option4);
        tt=findViewById(R.id.timert);
        scr=findViewById(R.id.score);


        updateQuestion();
    }

    @SuppressLint("ResourceAsColor")
    private void updateQuestion() {
        scr.setText(c+"/10");
        b1.setTextColor(R.color.colorPrimary);
        b2.setTextColor(R.color.colorPrimary);
        b3.setTextColor(R.color.colorPrimary);
        b4.setTextColor(R.color.colorPrimary);

        b1.setBackground(getResources().getDrawable(R.drawable.buttonbg));
        b2.setBackground(getResources().getDrawable(R.drawable.buttonbg));
        b3.setBackground(getResources().getDrawable(R.drawable.buttonbg));
        b4.setBackground(getResources().getDrawable(R.drawable.buttonbg));
        total++;
        if(total<10){
            Log.i("indside","Function");
            reference=FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    Questions questions=dataSnapshot.getValue(Questions.class);
                    qs.setText(questions.getQuestion());
                    b1.setText(questions.getOpt_A());
                    b2.setText(questions.getOpt_B());
                    b3.setText(questions.getOpt_C());
                    b4.setText(questions.getOpt_D());
                    final String an=questions.getAnswer();
                    //Toast.makeText(getApplicationContext(),"Answer is "+an,Toast.LENGTH_SHORT).show();
                    ct=new CountDownTimer(30000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            tt.setText( millisUntilFinished / 1000+" s");
                            b1.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View v) {
                                    if(an.equals(b1.getText().toString())){
                                        b1.setBackground(getResources().getDrawable(R.drawable.correct));
                                        b1.setTextColor(R.color.white);
                                        c++;
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                                ct.cancel();
                                            }
                                        },1000);
                                    }
                                    else{
                                        b1.setTextColor(R.color.white);
                                        b1.setBackground(getResources().getDrawable(R.drawable.wrong));
                                        if(an.equals(b2.getText())){
                                            b2.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b2.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b3.getText())){
                                            b3.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b3.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b4.getText())){
                                            b4.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b4.setTextColor(R.color.white);
                                        }
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();

                                            }
                                        },1000);
                                    }
                                }
                            });
                            b2.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View v) {
                                    if(an.equals(b2.getText().toString())){
                                        b2.setBackground(getResources().getDrawable(R.drawable.correct));
                                        b2.setTextColor(R.color.white);
                                        c++;
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();
                                            }
                                        },1000);
                                    }
                                    else{
                                        b2.setTextColor(R.color.white);
                                        b2.setBackground(getResources().getDrawable(R.drawable.wrong));
                                        if(an.equals(b1.getText())){
                                            b1.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b1.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b3.getText())){
                                            b3.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b3.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b4.getText())){
                                            b4.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b4.setTextColor(R.color.white);
                                        }
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                updateQuestion();
                                                ct.cancel();

                                            }
                                        },1000);
                                    }
                                }
                            });

                            b3.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View v) {
                                    if(an.equals(b3.getText().toString())){
                                        b3.setBackground(getResources().getDrawable(R.drawable.correct));
                                        b3.setTextColor(R.color.white);
                                        c++;
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();
                                            }
                                        },1000);
                                    }
                                    else{
                                        b3.setTextColor(R.color.white);
                                        b3.setBackground(getResources().getDrawable(R.drawable.wrong));
                                        if(an.equals(b2.getText())){
                                            b2.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b2.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b1.getText())){
                                            b1.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b1.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b4.getText())){
                                            b4.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b4.setTextColor(R.color.white);
                                        }
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();

                                            }
                                        },1000);
                                    }
                                }
                            });

                            b4.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onClick(View v) {
                                    if(an.equals(b4.getText().toString())){
                                        b4.setBackground(getResources().getDrawable(R.drawable.correct));
                                        b4.setTextColor(R.color.white);
                                        c++;
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();
                                            }
                                        },1000);
                                    }
                                    else{
                                        b4.setTextColor(R.color.white);
                                        b4.setBackground(getResources().getDrawable(R.drawable.wrong));
                                        if(an.equals(b2.getText())){
                                            b2.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b2.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b3.getText())){
                                            b3.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b3.setTextColor(R.color.white);
                                        }
                                        else if(an.equals(b1.getText())){
                                            b1.setBackground(getResources().getDrawable(R.drawable.correct));
                                            b1.setTextColor(R.color.white);
                                        }
                                        Handler handler=new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {

                                                updateQuestion();
                                                ct.cancel();

                                            }
                                        },1000);
                                    }
                                }
                            });
                        }

                        public void onFinish() {
                            tt.setText("Done");
                            updateQuestion();
                        }
                    }.start();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else
        {
            Intent i=new Intent(getApplicationContext(),ScoreActivity.class);
            i.putExtra("score",c);
            startActivity(i);
            finish();
        }
    }


}

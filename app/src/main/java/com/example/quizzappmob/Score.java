package com.example.quizzappmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.lzyzsd.circleprogress.DonutProgress;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        DonutProgress dp =findViewById(R.id.donut_progress);
        dp.setProgress(Quizz1.score*25);

        Button btr= findViewById(R.id.btn_retry);
        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quizz1.score=0;
                startActivity(new Intent(Score.this,Quizz1.class));
            }
        });

        Button bth= findViewById(R.id.btn_home);
        bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Score.this,MainActivity.class));

            }
        });
    }
}

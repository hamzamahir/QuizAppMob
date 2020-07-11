package com.example.quizzappmob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Quizz1 extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static int score=0;
    public String correct;
    RadioGroup rg1;
    public boolean cnt=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz1);
        rg1=findViewById(R.id.radio1);
        Button btn1= findViewById(R.id.next1);
        final DatabaseReference myRef = database.getReference().child("questions");
        final ImageView image = findViewById(R.id.img1);
        final TextView textview= findViewById(R.id.question1);
        final RadioButton radiobutton1= findViewById(R.id.q1r1);
        final RadioButton radiobutton2= findViewById(R.id.q1r2correct);

        DatabaseReference dbr = myRef.child("1");
        dbr.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    image.setImageResource(getResources().getIdentifier(snapshot.child("imageName").getValue().toString(),"drawable", getApplicationContext().getPackageName()));
                    textview.setText(snapshot.child("question").getValue().toString());
                    radiobutton1.setText(snapshot.child("choix1").getValue().toString());
                    radiobutton2.setText(snapshot.child("choix2").getValue().toString());
                    correct= snapshot.child("reponse").getValue().toString();

                } else {
                    Toast.makeText(getApplicationContext(), " Impossible", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cnt)
                {
                    startActivity(new Intent(Quizz1.this, Quizz2.class));                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Veuillez choisir une réponse",Toast.LENGTH_LONG).show();

                }

            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cnt=true;
                RadioButton b =findViewById(checkedId);
                if(b.getText().equals(correct))
                {
                    score = score +1 ;
                    b.setTextColor(Color.GREEN);
                    for(int i = 0; i < group.getChildCount(); i++){
                        (group.getChildAt(i)).setEnabled(false);
                    }
                }else{
                    b.setTextColor(Color.RED);
                    for(int i = 0; i < group.getChildCount(); i++) {

                        (group.getChildAt(i)).setEnabled(false);
                    }
                }
                b.setChecked(false);

            }
        });
    }
}

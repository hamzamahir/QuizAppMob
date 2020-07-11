package com.example.quizzappmob;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import modules.Questions;


public class Login extends AppCompatActivity {

    EditText LogineT,PasswordeT;
    Button LoginBtn;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String lgn_pwd;

    //this one
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Questions.questionsFB();

        TextView tv= findViewById(R.id.textview1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));

            }
        });
        LoginBtn = (Button) findViewById(R.id.button1);
        LogineT = ((EditText) findViewById(R.id.login1));
        PasswordeT= ((EditText) findViewById(R.id.mdp1));
        final DatabaseReference myRef = database.getReference().child("users");
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(LogineT.getText().toString().isEmpty()) && !PasswordeT.getText().toString().isEmpty())
                {
                    lgn_pwd= LogineT.getText().toString()+"_"+PasswordeT.getText().toString();
                    Query query = myRef.orderByChild("login_password").equalTo(lgn_pwd);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists())
                            {
                                startActivity(new Intent(Login.this,Quizz1.class));

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext()," Incorrect", Toast.LENGTH_LONG).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Tous les champs doivent etre remplis",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}

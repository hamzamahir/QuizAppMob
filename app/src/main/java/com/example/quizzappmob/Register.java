package com.example.quizzappmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import modules.User;

public class Register extends AppCompatActivity {
    EditText NameeT,EmaileT,LogineT,PasswordeT;
    Button RegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterBtn = (Button) findViewById(R.id.button2);
        NameeT = ((EditText) findViewById(R.id.name1));
        EmaileT = ((EditText) findViewById(R.id.email1));
        LogineT = ((EditText) findViewById(R.id.login2));
        PasswordeT= ((EditText) findViewById(R.id.passwordreg));

        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!NameeT.getText().toString().isEmpty() && !EmaileT.getText().toString().isEmpty() && !(LogineT.getText().toString().isEmpty()) && !PasswordeT.getText().toString().isEmpty() )
                {
                    User user = new User(NameeT.getText().toString(),EmaileT.getText().toString(),LogineT.getText().toString(),PasswordeT.getText().toString(), LogineT.getText().toString()+"_"+PasswordeT.getText().toString());
                    Log.i("tag",user.toString());
                    user.FBWrite("2");
                    Toast.makeText(getApplicationContext(),"Inscription effectuée",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this,Login.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Veuillez remplir tous les champs",Toast.LENGTH_SHORT).show();

                }

            }
        });

        TextView tv= findViewById(R.id.textView5);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this,Login.class));

            }
        });

    }
}


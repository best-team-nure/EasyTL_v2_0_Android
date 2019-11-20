package com.example.easytl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PassRestore extends AppCompatActivity {

    EditText userEmail;
    FirebaseAuth mFirebaseAuth;
    Button resend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_restore);
        userEmail = findViewById(R.id.email_input_passres);
        resend = findViewById(R.id.respass_btn);
        mFirebaseAuth = FirebaseAuth.getInstance();
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseAuth.sendPasswordResetEmail(userEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(PassRestore.this,"Скорее смотри почту, там тебе письмо пришло!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(PassRestore.this, LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(PassRestore.this,"Упс, возникла ошибка :( Проверь данные :)", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
    public void backBut(View view) {
        Intent intent = new Intent(PassRestore.this, LoginActivity.class);
        startActivity(intent);
    }
    public void resendPass(){
        userEmail = findViewById(R.id.email_input_passres);

    }
}

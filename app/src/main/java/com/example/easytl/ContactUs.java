package com.example.easytl;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class ContactUs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }

    public void backBut(View view) {
        Intent intent = new Intent(ContactUs.this, FAQ.class);
        startActivity(intent);
    }

    public void sendMes(View v) {
        Toast.makeText(ContactUs.this, "Дружище, к сожалению эта функция пока не доступна :( Но не унывай, в скором времени мы ее добавим :) Если очень хочешь, то напиши нам на почту 'easybreazy.tl@gmail.com'", Toast.LENGTH_SHORT).show();
    }
}

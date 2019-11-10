package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultQuick extends AppCompatActivity {

    int score;
    int minutes;
    int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_quick);

        showResults();
        User.loadQuickTestData( 20, score, (minutes*60+seconds));
    }

    public void backBtnOnClick(View view) {
        Intent intent = new Intent(view.getContext(), EasyTL.class);
        startActivity(intent);
    }

    private void showResults() {

        score = getIntent().getIntExtra("score", 0);
        minutes = getIntent().getIntExtra("minutes", 0);
        seconds = getIntent().getIntExtra("seconds", 0);

        String result;
        if (score >= 18) {
            result = "Тест пройден!";
        } else {
            result = "Тест провален!";
        }

        String timeRes;
        if (seconds != 0) {
            if (seconds < 50) {
                timeRes = (20 - minutes - 1) + ":" + (60 - seconds);
            } else {
                timeRes = (20 - minutes - 1) + ":0" + (60 - seconds);
            }
        } else {
            timeRes = (20 - minutes) + ":00";
        }

        TextView questionResTV = (TextView) findViewById(R.id.questionResTextView);
        TextView timeResTV = (TextView) findViewById(R.id.timeResTextView);
        TextView totalResTV = (TextView) findViewById(R.id.totalResTextView);

        questionResTV.setText("Правильных ответов: " + score + " из 20");
        timeResTV.setText("Времени затрачено: " + timeRes);
        totalResTV.setText(result);
    }
}

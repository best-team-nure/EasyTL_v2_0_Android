package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultTheory  extends AppCompatActivity {

    private int score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_theory);
        score = getIntent().getIntExtra("score", 0);
        showResults();
        User.loadTheoryTestData(5,score);
    }

    public void backBtnOnClick(View view) {
        Intent intent = new Intent(view.getContext(), EasyTL.class);
        startActivity(intent);
    }

    private void showResults() {

        score = getIntent().getIntExtra("score", 0);

        String result = "";
        switch (score) {
            case 0:
            case 1:
            case 2:
                result = "Тест провален!";
                break;
            case 3:
            case 4:
                result = "Тест пройден, но я знаю, что ты можешь лучше!";
                break;
            case 5:
                result = "Тест пройден!";
                break;
        }

        TextView questionResTV = (TextView) findViewById(R.id.questionResTextView2);
        TextView totalResTV = (TextView) findViewById(R.id.totalResTextView2);

        questionResTV.setText("Правильных ответов: " + score + " из 5");
        totalResTV.setText(result);
    }
}

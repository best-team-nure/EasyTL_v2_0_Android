package com.example.easytl;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FAQ extends AppCompatActivity {
    private Button bq;
    private TextView q;
    private TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        bq = (Button) findViewById(R.id.b_q1);
        q = (TextView)findViewById(R.id.q1);
        bq.setBackgroundResource(R.drawable.help_but_hover);
        q.setTypeface(Typeface.DEFAULT_BOLD);
        ans = (TextView)findViewById(R.id.ans);
        ans.setText("Нажать кнопку старт, прочитать теорию и начать проходить тест по пункту теории.\nТакже вы можете пройти тест из 20 случайных вопросов нажав на кнопку 'Быстрый тест'.");
    }
    public void backBut(View view){
        Intent intent = new Intent(FAQ.this, EasyTL.class);
        startActivity(intent);
    }
    public void contUs(View view){
        Intent intent = new Intent(FAQ.this, ContactUs.class);
        startActivity(intent);
    }
    public void questStyleChange(View view) {
        switch (view.getId()) {
            case R.id.q1:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q1);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Нажать кнопку старт, прочитать теорию и начать проходить тест по пункту теории.\n\nТакже вы можете пройти тест из 20 случайных вопросов нажав на кнопку \"Быстрый тест\".");
                break;
            case R.id.q2:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q2);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Регистрация нужна для статистики, то есть для сохранения результатов теста.\n\nВы также сможете поделиться своими результатами с друзьями.");
                break;
            case R.id.q3:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q3);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Результат сохраняется автоматически, если вы авторизовались.");
                break;
            case R.id.q4:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q4);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Нажимаете на кнопку \"Поделиться\" в профиле и выбираете нужную вам соцсеть.");
                break;
            case R.id.q5:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q5);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("За прохождения теста, соответствующего пункту теории без ошибок, вы получите одну звезду.\n\nЗвезды нельзя купить, только заработать.");
                break;
            case R.id.q6:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q6);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Вопросы соответствуют официальным вопросам теста в ГАИ.");
                break;
            case R.id.q7:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q7);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Вопросы для категории B.");
                break;
            case R.id.q8:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(R.id.b_q8);
                q = (TextView) findViewById(view.getId());
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Этот тест нельзя использовать как подтверждение категории.");
                break;
        }
    }

        public void butColChange(View view){
        switch (view.getId()) {
            case R.id.b_q1:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q1);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Нажать кнопку старт, прочитать теорию и начать проходить тест по пункту теории.\nТакже вы можете пройти тест из 20 случайных вопросов нажав на кнопку 'Быстрый тест'.");
                break;
            case R.id.b_q2:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q2);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Регистрация нужна для статистики, то есть для сохранения результатов теста.\n\nВы также сможете поделиться своими результатами с друзьями.");
                break;
            case R.id.b_q3:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q3);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Результат сохраняется автоматически, если вы авторизовались.");
                break;
            case R.id.b_q4:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q4);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Нажимаете на кнопку \"Поделиться\" в профиле и выбираете нужную вам соцсеть.");
                break;
            case R.id.b_q5:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q5);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("За прохождения теста, соответствующего пункту теории без ошибок, вы получите одну звезду.\n\nЗвезды нельзя купить, только заработать.");
                break;
            case R.id.b_q6:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q6);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Вопросы соответствуют официальным вопросам теста в ГАИ.");
                break;
            case R.id.b_q7:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q7);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Вопросы для категории B.");
                break;
            case R.id.b_q8:
                q.setTypeface(Typeface.DEFAULT);
                bq.setBackgroundResource(R.drawable.help_but);
                bq = (Button) findViewById(view.getId());
                q = (TextView)findViewById(R.id.q8);
                bq.setBackgroundResource(R.drawable.help_but_hover);
                q.setTypeface(Typeface.DEFAULT_BOLD);
                ans.setText("Этот тест нельзя использовать как подтверждение категории.");
                break;
        }

    }
}

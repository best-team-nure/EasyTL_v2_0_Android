package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TheoryQuestion  extends AppCompatActivity {

    int topicNumber;
    int questionNumber;
    static int rightAnswersNumber;
    Question question;
    WebView gifochkaWV;
    RadioButton answerRB1;
    RadioButton answerRB2;
    TextView questionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_question);

        topicNumber = getIntent().getIntExtra("topicNum", 0);
        questionNumber = getIntent().getIntExtra("questionNum", 0);
        if (questionNumber == 0) { rightAnswersNumber = 0; }

        questionTV =  (TextView) findViewById(R.id.questionTextView);
        answerRB1 = (RadioButton) findViewById(R.id.answerRadioButton1);
        answerRB2 = (RadioButton) findViewById(R.id.answerRadioButton2);
        gifochkaWV = (WebView) findViewById(R.id.gifochkaWebView);

        question = new Question(topicNumber, questionNumber);
        questionTV.setText(question.getQuestionStatement());
        answerRB1.setText(question.getAnswer(0));
        answerRB2.setText(question.getAnswer(1));
        gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumber + "/q" + questionNumber + ".html");
    }

    public void answerRBclick_0(View view) {
        gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumber + "/q" + questionNumber + "-a0.html");
        answerRB1.setEnabled(false);
        answerRB2.setEnabled(false);
        if (question.indexOfCorrectAnswer() == 0) {
            rightAnswersNumber++;
        }
    }

    public void answerRBclick_1(View view) {
        gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumber + "/q" + questionNumber + "-a1.html");
        RadioGroup answerRG = (RadioGroup) findViewById(R.id.answerRadioGroup);
        answerRB1.setEnabled(false);
        answerRB2.setEnabled(false);
        if (question.indexOfCorrectAnswer() == 1) {
            rightAnswersNumber++;
        }
    }

    public void backBut(View view){
        try {
            Intent intent = new Intent(view.getContext(), Theory.class);
            intent.putExtra("topicNum", topicNumber);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(TheoryQuestion.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void nextBut (View view) {
        if (questionNumber == 4) {
            try {
                Intent intent = new Intent(view.getContext(), ResultTheory.class);
                intent.putExtra("score", rightAnswersNumber);
                User.setTopicNumber(topicNumber);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(TheoryQuestion.this, e.toString(), Toast.LENGTH_SHORT).show();
            }

        } else {
            try {
                Intent intent = new Intent(view.getContext(), TheoryQuestion.class);
                intent.putExtra("topicNum", topicNumber);
                intent.putExtra("questionNum", questionNumber + 1);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(TheoryQuestion.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
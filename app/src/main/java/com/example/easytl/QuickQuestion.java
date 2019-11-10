package com.example.easytl;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuickQuestion extends AppCompatActivity {

    private Question[] questions = new Question[20];
    private int [] userAnswers = new int[20];
    private int [] rightAnswersIndex = new int[20];
    private int score;
    private int minutes;
    private int seconds;

    // these arrays are for loading gifs. Numbers here are global.
    private int topicNumbers[] = new int[20];
    private int questionNumbers[] = new int[20];

    // this var contains a number of current question in current test.
    private int questionNumber;

    WebView gifochkaWV;
    TextView questionTV;
    RadioButton answerRB1;
    RadioButton answerRB2;
    RadioGroup answerRG;
    TextView questionNumTV;
    TextView timerTV;
    Button backB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_question);

        questionNumber = 0;
        findViews();
        generateTest();
        loadQuestion();
        startTimer();
    }

    private void loadQuestion() {
        questionTV.setText(questions[questionNumber].getQuestionStatement());
        answerRB1.setText(questions[questionNumber].getAnswer(0));
        answerRB2.setText(questions[questionNumber].getAnswer(1));
        questionNumTV.setText("Вопрос:\n" + (questionNumber + 1) + " из 20");

        if (questionNumber == 0) {
            backB.setVisibility(View.INVISIBLE);
        } else {
            backB.setVisibility(View.VISIBLE);
        }

        switch(userAnswers[questionNumber]) {
            case -1:
                gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumbers[questionNumber] + "/q" +
                        questionNumbers[questionNumber] + ".html");
                answerRB1.setEnabled(true);
                answerRB2.setEnabled(true);
                answerRB1.setChecked(false);
                answerRB2.setChecked(false);
                break;
            case 0:
                answerRB1.setChecked(true);
                answerRB1.setEnabled(false);
                answerRB2.setEnabled(false);
                gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumbers[questionNumber] + "/q" +
                        questionNumbers[questionNumber] + "-a0.html");
                break;
            case 1:
                answerRB2.setChecked(true);
                answerRB1.setEnabled(false);
                answerRB2.setEnabled(false);
                gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumbers[questionNumber] + "/q" +
                        questionNumbers[questionNumber] + "-a1.html");
                break;
        }
    }

    private void generateTest() {

        score = 0;
        int totalQuestions = 20;
        int topicNum;
        int questionNum;
        boolean repetitionFlag;

        for (int i = 0; i < totalQuestions; i++) {

            do {
                repetitionFlag = false;

                // random number [0;5]
                topicNum = (int) (Math.random() * 6);

                // random number [0;4]
                questionNum = (int) (Math.random() * 5);

                // check if we already have this question in our test
                for (int j = 0; j < i; j++) {
                    if (topicNumbers[j] == topicNum && questionNumbers[j] == questionNum) {
                        repetitionFlag = true;
                        break;
                    }
                }
            } while(repetitionFlag);
                topicNumbers[i] = topicNum;
                questionNumbers[i] = questionNum;
                questions[i] = new Question(topicNum, questionNum);
                rightAnswersIndex[i] = questions[i].indexOfCorrectAnswer();
        }

        for (int i = 0; i < totalQuestions; i++) {
            userAnswers[i] = -1;
        }
    }

    private void findViews(){
        questionTV =  (TextView) findViewById(R.id.questionTextView);
        answerRB1 = (RadioButton) findViewById(R.id.answerRadioButton1);
        answerRB2 = (RadioButton) findViewById(R.id.answerRadioButton2);
        answerRG = (RadioGroup) findViewById(R.id.answerRadioGroup);
        gifochkaWV = (WebView) findViewById(R.id.gifochkaWebView);
        questionNumTV = (TextView) findViewById(R.id.questionNumTextView);
        timerTV = (TextView) findViewById(R.id.timerTextView);
        backB = (Button) findViewById(R.id.backButton);
    }

    public void answerRBclick_0(View view) {
        gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumbers[questionNumber] + "/q" +
                questionNumbers[questionNumber] + "-a0.html");
        answerRB1.setEnabled(false);
        answerRB2.setEnabled(false);
        userAnswers[questionNumber] = 0;
        if (rightAnswersIndex[questionNumber] == 0) {
            score++;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Ошибочка!")
                    .setMessage(questions[questionNumber].getComment())
                    .setIcon(R.drawable.help_but)
                    .setCancelable(false)
                    .setNegativeButton("Я всё понял",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public void answerRBclick_1(View view) {
        gifochkaWV.loadUrl("file:///android_asset/t-" + topicNumbers[questionNumber] + "/q" +
                questionNumbers[questionNumber] + "-a1.html");
        answerRB1.setEnabled(false);
        answerRB2.setEnabled(false);
        userAnswers[questionNumber] = 1;
        if (rightAnswersIndex[questionNumber] == 1) {
            score++;
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Ошибочка!")
                    .setMessage(questions[questionNumber].getComment())
                    .setIcon(R.drawable.help_but)
                    .setCancelable(false)
                    .setNegativeButton("Я всё понял",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public void backBut(View view){
        if (questionNumber == 0) {
            try {
                Intent intent = new Intent(view.getContext(), EasyTL.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
            }
        } else {
            questionNumber--;
            loadQuestion();
        }
    }

    public void nextBut (View view) {
        if (questionNumber == 19) {
            Intent intent = new Intent(view.getContext(), ResultQuick.class);
            intent.putExtra("score", score);
            intent.putExtra("minutes", minutes);
            intent.putExtra("seconds", seconds);
            startActivity(intent);
        } else {
            questionNumber++;
            loadQuestion();
        }
    }

    public void veryBackButtonClick(View view) {
        try {
            Intent intent = new Intent(view.getContext(), EasyTL.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(view.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void startTimer() {
        new CountDownTimer(1200000, 1000) {

            @Override
            public void onTick(long time) {
                minutes = (int) (time/60000);
                seconds = (int) (time/1000 - minutes*60);
                String min;
                String sec;
                if (minutes < 10) {
                    min = "0" + minutes;
                } else {
                    min = "" + minutes;
                }
                if (seconds < 10) {
                    sec = "0" + seconds;
                } else {
                    sec = "" + seconds;
                }
                timerTV.setText("Оставшееся время:\n" + min + ":" + sec);
            }

            @Override
            public void onFinish() {
                timerTV.setText("Оставшееся время:\n-");
            }
        }.start();
    }
}

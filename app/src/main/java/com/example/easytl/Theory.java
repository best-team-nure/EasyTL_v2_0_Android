package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Theory extends AppCompatActivity {

    int topicNumber;

    int [] topicName = new int[] {
            R.string.topic_name_0,
            R.string.topic_name_1,
            R.string.topic_name_2,
            R.string.topic_name_3,
            R.string.topic_name_4,
            R.string.topic_name_5,
    };

    int [] content = new int[] {
            R.string.theory_content_0,
            R.string.theory_content_1,
            R.string.theory_content_2,
            R.string.theory_content_3,
            R.string.theory_content_4,
            R.string.theory_content_5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        topicNumber = getIntent().getIntExtra("topicNum", 0);

        TextView topicNameTV =  (TextView) findViewById(R.id.topicNameTextView);
        TextView contentTV =  (TextView) findViewById(R.id.contentTextView);

        topicNameTV.setText(topicName[topicNumber]);
        contentTV.setText(content[topicNumber]);
    }

    public void backBut(View view){

        Intent intent = new Intent(view.getContext(), PickTheory.class);
        startActivity(intent);
    }

    public void nextBut (View view) {
        int questionNumber = 0;
        Intent intent = new Intent(view.getContext(), TheoryQuestion.class);
        intent.putExtra("topicNum", topicNumber);
        intent.putExtra("questionNum", questionNumber);
        startActivity(intent);
    }
}

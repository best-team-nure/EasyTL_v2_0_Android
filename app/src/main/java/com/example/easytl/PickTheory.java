package com.example.easytl;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TableRow;
import android.view.View.OnClickListener;

public class PickTheory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_theory);

        int maxTopicNum = User.getTopicProgress();
        openTopics(maxTopicNum);
    }
    public void backBut(View view){
        Intent intent = new Intent(PickTheory.this, EasyTL.class);
        startActivity(intent);
    }

    private void chooseTopic(View view, int topicNum){
        Intent intent = new Intent(PickTheory.this, Theory.class);
        intent.putExtra("topicNum", topicNum);
        startActivity(intent);
    }

    // there is a kostyl' here. But we need it(
    private void openTopics(int maxTopicNum) {
        TableRow tableRow;
        tableRow = (TableRow) findViewById(R.id.t0);

        OnClickListener listener;

        listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseTopic(v, 0);
            }
        };
        tableRow.setOnClickListener(listener);

        if (maxTopicNum > 0) {
            tableRow.setBackgroundResource(R.drawable.t_passed);
            tableRow = (TableRow) findViewById(R.id.t1);

            listener = new OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseTopic(v, 1);
                }
            };
            tableRow.setOnClickListener(listener);

            if(maxTopicNum > 1) {
                tableRow.setBackgroundResource(R.drawable.t_passed);
                tableRow = (TableRow) findViewById(R.id.t2);

                listener = new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        chooseTopic(v, 2);
                    }
                };
                tableRow.setOnClickListener(listener);

                if (maxTopicNum > 2) {
                    tableRow.setBackgroundResource(R.drawable.t_passed);
                    tableRow = (TableRow) findViewById(R.id.t3);

                    listener = new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            chooseTopic(v, 3);
                        }
                    };
                    tableRow.setOnClickListener(listener);

                    if(maxTopicNum > 3) {
                        tableRow.setBackgroundResource(R.drawable.t_passed);
                        tableRow = (TableRow) findViewById(R.id.t4);

                        listener = new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                chooseTopic(v, 4);
                            }
                        };
                        tableRow.setOnClickListener(listener);

                        if (maxTopicNum > 4) {
                            tableRow.setBackgroundResource(R.drawable.t_passed);
                            tableRow = (TableRow) findViewById(R.id.t5);

                            listener = new OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    chooseTopic(v, 5);
                                }
                            };
                            tableRow.setOnClickListener(listener);

                            tableRow.setBackgroundResource(R.drawable.t_open);

                            if (maxTopicNum > 5) {
                                tableRow.setBackgroundResource(R.drawable.t_passed);
                                tableRow = (TableRow) findViewById(R.id.t6);

                                listener = new OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        chooseTopic(v, 6);
                                    }
                                };
                                tableRow.setOnClickListener(listener);

                                tableRow.setBackgroundResource(R.drawable.t_open);

                                if (maxTopicNum > 6) {
                                    tableRow.setBackgroundResource(R.drawable.t_passed);
                                    tableRow = (TableRow) findViewById(R.id.t7);

                                    listener = new OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            chooseTopic(v, 7);
                                        }
                                    };
                                    tableRow.setOnClickListener(listener);

                                    tableRow.setBackgroundResource(R.drawable.t_open);

                                } else {
                                    tableRow.setBackgroundResource(R.drawable.t_open);
                                }
                            } else {
                                tableRow.setBackgroundResource(R.drawable.t_open);
                            }
                        } else {
                            tableRow.setBackgroundResource(R.drawable.t_open);
                        }
                    } else {
                        tableRow.setBackgroundResource(R.drawable.t_open);
                    }
                } else {
                    tableRow.setBackgroundResource(R.drawable.t_open);
                }
            } else {
                tableRow.setBackgroundResource(R.drawable.t_open);
            }
        } else {
            tableRow.setBackgroundResource(R.drawable.t_open);
        }
    }
}

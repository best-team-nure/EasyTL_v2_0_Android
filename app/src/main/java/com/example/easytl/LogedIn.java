package com.example.easytl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class LogedIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    TextView uname;

    String name;
    int topProgress;
    int correctQuestions; //for both
    int totalTests; // quick only
    int passedTests; // quick only
    int averageCorrectAnswers; // quick only
    int averageTime; // quick only. seconds
    int totalQuestions; //for both
    long[] stars_arr;
    String id;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    TextView qText;
    TextView allqText;
    TextView allq;
    TextView corqText;
    TextView corq;
    TextView tText;
    TextView alltText;
    TextView allt;
    TextView pasTtext;
    TextView passedT;
    TextView averText;
    TextView averAnsText;
    TextView averAns;
    TextView averAnsText2;
    TextView averTimeText;
    TextView averTime;
    TextView averTimeText2;

    ImageView[] stars_arr_IV = new ImageView[5];
    CircleImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_loged_in);
        Toolbar toolbar = findViewById(R.id.toolbarlogged);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.loggedin_drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        uname  = (TextView) header.findViewById(R.id.username_loged);
        stars_arr_IV[0] = (ImageView) header.findViewById(R.id.firstS);
        stars_arr_IV[1] = (ImageView) header.findViewById(R.id.secS);
        stars_arr_IV[2] = (ImageView) header.findViewById(R.id.thirdS);
        stars_arr_IV[3] = (ImageView) header.findViewById(R.id.fourthS);
        stars_arr_IV[4] = (ImageView) header.findViewById(R.id.fifthS);
        avatar = (CircleImageView) header.findViewById(R.id.circleImageView);
        id = mAuth.getInstance().getCurrentUser().getUid();
        myRef = FirebaseDatabase.getInstance().getReference(id);
        topProgress = User.getTopicProgress();
        totalTests = User.getTotalTests(); // quick only
        passedTests = User.getPassedTests(); // quick only
        averageCorrectAnswers = User.getAverageCorrectAnswers(); // quick only
        averageTime = User.getAverageTime();
        correctQuestions = User.getCorrectQuestions();// quick only. seconds
        totalQuestions = User.getTotalQuestions();
        stars_arr = User.getStars();
        if (User.getName() != null) {
            name = User.getName();
            Map<String, Object> users = new HashMap<String, Object>();
            users.put("Name", name);
            users.put("passedTopics", topProgress);
            myRef.setValue(users);
            myRef = FirebaseDatabase.getInstance().getReference(id).child("Stars");
            users = new HashMap<String, Object>();
            for(int i = 0; i < stars_arr.length; i++){
                users.put(Integer.toString(i), stars_arr[i]);
            }
//            fillStarArr();
//            users.put("0", stars_arr[0]);
//            users.put("1", stars_arr[1]);
//            users.put("2", stars_arr[2]);
//            users.put("3", stars_arr[3]);
//            users.put("4", stars_arr[4]);
//            users.put("5", stars_arr[5]);

            myRef.setValue(users);
            myRef = FirebaseDatabase.getInstance().getReference(id).child("averages");
            users = new HashMap<String, Object>();
            users.put("correctAnswers", averageCorrectAnswers);
            users.put("time", averageTime);
            myRef.setValue(users);
            myRef = FirebaseDatabase.getInstance().getReference(id).child("questions");
            users = new HashMap<String, Object>();
            users.put("correct", correctQuestions);
            users.put("total", totalQuestions);
            myRef.setValue(users);
            myRef = FirebaseDatabase.getInstance().getReference(id).child("tests");
            users = new HashMap<String, Object>();
            users.put("passed", passedTests);
            users.put("total", totalTests);
            myRef.setValue(users);
        }
        myRef = FirebaseDatabase.getInstance().getReference(id);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                name = dataSnapshot.child("Name").getValue(String.class);
                uname.setText(name);
                if(dataSnapshot.child("passedTopics").getValue() != null) {
                    topProgress = dataSnapshot.child("passedTopics").getValue(Integer.class);
                }else{
                    topProgress = 0;
                }
                if(dataSnapshot.child("questions").child("total").getValue() != null) {
                    totalQuestions = dataSnapshot.child("questions").child("total").getValue(Integer.class);
                }else{
                    totalQuestions = 0;
                }
                allq.setText(String.format(Locale.getDefault(),"%d", totalQuestions));
                    if(dataSnapshot.child("questions").child("correct").getValue() != null)
                    {
                        correctQuestions = dataSnapshot.child("questions").child("correct").getValue(Integer.class);
                    }else{
                        correctQuestions = 0;
                    }
                corq.setText(Integer.toString(correctQuestions));
                    if(dataSnapshot.child("tests").child("total").getValue() != null) {
                        totalTests = dataSnapshot.child("tests").child("total").getValue(Integer.class);
                    } else {
                        totalTests = 0;
                    }
                    allt.setText(String.format(Locale.getDefault(),"%d", totalTests));
                    if(dataSnapshot.child("tests").child("passed").getValue()!= null){
                        passedTests = dataSnapshot.child("tests").child("passed").getValue(Integer.class);
                    } else{
                        passedTests = 0;
                    }
                    passedT.setText(String.format(Locale.getDefault(),"%d", passedTests));
                    if(dataSnapshot.child("averages").child("correctAnswers").getValue()!= null){
                        averageCorrectAnswers = dataSnapshot.child("averages").child("correctAnswers").getValue(Integer.class);
                    } else{
                        averageCorrectAnswers = 0;
                    }
                    averAns.setText(String.format(Locale.getDefault(),"%d", averageCorrectAnswers));
                    if(dataSnapshot.child("averages").child("time").getValue() != null){
                        averageTime = dataSnapshot.child("averages").child("time").getValue(Integer.class);
                    } else{
                        averageTime = 0;
                    }
                    averTime.setText(String.format(Locale.getDefault(),"%d", averageTime));
                    for(int i = 0; i < stars_arr.length; i++) {
                        stars_arr[i] = dataSnapshot.child("Stars").child(String.format(Locale.getDefault(), "%d", i)).getValue(Long.class);
                    }
                    // fillStarArr();
                    colorStars();
                    User user = new User(id, name, topProgress, totalQuestions, correctQuestions, totalTests, passedTests, averageCorrectAnswers, averageTime, stars_arr);
            }catch (Exception e){
                   Log.d("Message", e.toString());
                }

            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(LogedIn.this, error.toException().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        callbackManager = CallbackManager.Factory.create();
        setTExtView();
        shareDialog = new ShareDialog(this);

    }

    private void setTExtView() {
        qText = (TextView) findViewById(R.id.q_text);
        allqText = (TextView) findViewById(R.id.all_q_text);
        allq = (TextView) findViewById(R.id.all_q);
        corqText = (TextView) findViewById(R.id.correct_q_text);
        corq = (TextView) findViewById(R.id.correct_q);
        tText = (TextView) findViewById(R.id.test_text);
        alltText = (TextView) findViewById(R.id.all_t_text);
        allt = (TextView) findViewById(R.id.all_t);
        pasTtext = (TextView) findViewById(R.id.paseed_t_text);
        passedT = (TextView) findViewById(R.id.paseed_t);
        averText = (TextView) findViewById(R.id.average_text);
        averAnsText = (TextView) findViewById(R.id.average_answ_text);
        averAns = (TextView) findViewById(R.id.average_answ);
        averAnsText2 = (TextView) findViewById(R.id.average_answ_text2);
        averTimeText = (TextView) findViewById(R.id.average_time_text);
        averTime = (TextView) findViewById(R.id.average_time);
        averTimeText2 = (TextView) findViewById(R.id.average_time_text2);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.loggedin_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    public void fillStarArr(){
////        int count_full_stars = stars/2;
////        int half_star = stars%2;
////        int i = 0;
////        while (i < count_full_stars){
////            stars_arr[i] = 2;
////            i++;
////        }
////        if(half_star == 1){
////            stars_arr[i] = 1;
////        }
////    }
    public int[] fillStarArr(){
        int sum = 0;
        for(int i = 0; i < stars_arr.length; i++){
            sum += stars_arr[i];
        }
        int[] stars = new int[stars_arr.length];
        int count_full_stars = sum/2;
        int half_star = sum%2;
        int i = 0;
        while (i < count_full_stars){
            stars[i] = 2;
            i++;
        }
        if(half_star == 1) {
            stars[i] = 1;
        }
        return stars;
    }
    public void avatarChange(){
        int sum = 0;
       for(int i = 0; i < stars_arr.length; i++){
            sum += stars_arr[i];
       }
        switch (sum){
            case 10:
                avatar.setImageResource(R.drawable.happy);
                break;
            case 0:
                avatar.setImageResource(R.drawable.sad);
                break;
            default:
                avatar.setImageResource(R.drawable.neutral);
                break;
        }
    }
    public void colorStars(){
        int[] arr = fillStarArr();
        for (int i = 0; i < stars_arr_IV.length; i++) {
            if(arr[i] == 1){
                stars_arr_IV[i].setImageResource(R.drawable.half_star);
            } else if(arr[i] == 2){
                stars_arr_IV[i].setImageResource(R.drawable.full_star);
            } else{
                stars_arr_IV[i].setImageResource(R.drawable.empt_star);
            }
        }
        avatarChange();
    }
//    public void colorStars(){
//        int sum = 0;
//        for(int i = 0; i < stars_arr.length; i++){
//            sum += stars_arr[i];
//        }
//        stars = sum;
//        avatarChange();
//        for (int i = 0; i < stars_arr_IV.length; i++) {
//            if(stars_arr[i] == 1){
//                stars_arr_IV[i].setImageResource(R.drawable.half_star);
//            } else if(stars_arr[i] == 2){
//                stars_arr_IV[i].setImageResource(R.drawable.full_star);
//            } else{
//                stars_arr_IV[i].setImageResource(R.drawable.empt_star);
//            }
//        }
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loged_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void exitBut(View view) {
        FirebaseAuth.getInstance().signOut();
        User user = new User(null, null);
        Intent intent = new Intent(LogedIn.this, EasyTL.class);
        startActivity(intent);
        LoginManager.getInstance().logOut();
    }

    public void helpBut(View view) {
        Intent intent = new Intent(LogedIn.this, FAQ.class);
        startActivity(intent);
    }

    public void theoryBut(View view) {
        Intent intent = new Intent(LogedIn.this, PickTheory.class);
        startActivity(intent);
    }

    public void testBut(View view) {
        Intent intent = new Intent(LogedIn.this, QuickQuestion.class);
        startActivity(intent);
    }

    public void fbShare(View view) {
        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setQuote("Хвастаюсь своими достижениями в EasyTL\n\n" + qText.getText().toString() + "\n\n" + allqText.getText().toString() + allq.getText().toString() + "\n" + corqText.getText().toString() + corq.getText().toString() + "\n\n" + tText.getText().toString() + "\n\n" + alltText.getText().toString() + allt.getText().toString() + "\n" + pasTtext.getText().toString() + passedT.getText().toString() + "\n\n" + averText.getText().toString() + "\n\n" + averAnsText.getText().toString() + averAns.getText().toString() + averAnsText2.getText().toString() + "\n" + averTimeText.getText().toString() + averTime.getText().toString() + averTimeText2.getText().toString())
                .setContentUrl(Uri.parse("https://easytlnew.web.app"))
                .build();
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            shareDialog.show(linkContent);
        }

    }
}

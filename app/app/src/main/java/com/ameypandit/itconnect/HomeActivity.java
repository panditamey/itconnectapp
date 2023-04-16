package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ameypandit.itconnect.notice.ViewNoticeActivity;
import com.ameypandit.itconnect.pdfreader.ViewPdfActivity;

import java.sql.Time;

public class HomeActivity extends AppCompatActivity {

    LinearLayout VideoLecll;
    LinearLayout Ebookll;
    LinearLayout Facultyll;
    LinearLayout Noticesll;
    LinearLayout Developerll;

    LinearLayout TimeTablell;

    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;


    //must be comment in admin version
    LinearLayout Adminll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences= this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.getString("isLogin","false").equals("false")){
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }

        VideoLecll = findViewById(R.id.videolec);
        Ebookll = findViewById(R.id.pdf);
        Facultyll = findViewById(R.id.faculty);
        Noticesll = findViewById(R.id.notices);
        Developerll = findViewById(R.id.developer);
        TimeTablell = findViewById(R.id.timetable);

        //comment this in user version
//        Adminll = findViewById(R.id.admin);


        VideoLecll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, LecturesActivity.class);
                startActivity(intent);
            }
        });

        Ebookll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoebook = new Intent(HomeActivity.this, ViewPdfActivity.class);
                startActivity(gotoebook);
            }
        });

        Facultyll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoFaculty = new Intent(HomeActivity.this, FacultyActivity.class);
                startActivity(gotoFaculty);
            }
        });

        Noticesll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Viewnotice = new Intent(HomeActivity.this, ViewNoticeActivity.class);
                startActivity(Viewnotice);
            }
        });

        Developerll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        TimeTablell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW) ;
                intent.setDataAndType(Uri.parse("https://timetable.ameypandit.workers.dev/0:/tt.pdf"),"application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        //to be comment in user version

//        Adminll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, AdminActivity.class);
//                startActivity(intent);
//            }
//        });
    }

}
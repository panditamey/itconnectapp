package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class FacultyActivity extends AppCompatActivity {

    CircleImageView dm,sb,rm,as,dp,da,svb,sg,og,sd,swb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dm=findViewById(R.id.dmimg);
        sb=findViewById(R.id.sbimg);
        rm=findViewById(R.id.rmimg);
        as=findViewById(R.id.asimg);
        dp=findViewById(R.id.dpimg);
        da=findViewById(R.id.daimg);
        svb=findViewById(R.id.svbimg);
        sg=findViewById(R.id.sgimg);
        og=findViewById(R.id.ogimg);
        sd=findViewById(R.id.sdimg);
        swb=findViewById(R.id.sbafnaimg);

        //Loading Image

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder);
        requestOptions.error(R.drawable.placeholder);

        Glide.with(FacultyActivity.this)
                .load("https://www.atharvacoe.ac.in/wp-content/uploads/deepali_maste.jpg")
                .apply(requestOptions)
                .into(dm);
        Glide.with(FacultyActivity.this)
                .load("https://www.atharvacoe.ac.in/wp-content/uploads/Snigdha-Wasnik.jpg")
                .apply(requestOptions)
                .into(sb);
        Glide.with(FacultyActivity.this)
                .load("https://www.atharvacoe.ac.in/wp-content/uploads/Amruta_Sankhe.jpg")
                .apply(requestOptions)
                .into(as);
        Glide.with(FacultyActivity.this)
                .load("https://www.atharvacoe.ac.in/wp-content/uploads/suchita-1.jpg")
                .apply(requestOptions)
                .into(sg);
        Glide.with(FacultyActivity.this)
                .load("https://www.atharvacoe.ac.in/wp-content/uploads/Odilia.jpg")
                .apply(requestOptions)
                .into(og);

    }
}
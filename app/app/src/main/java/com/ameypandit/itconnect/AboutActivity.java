package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    CircleImageView ameypanditIV;
    ImageView linkedin , github , www , mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ameypanditIV = findViewById(R.id.ameypanditIV);
        linkedin = findViewById(R.id.linkedin);
        github = findViewById(R.id.github);
        www = findViewById(R.id.www);
        mail = findViewById(R.id.mail);

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/panditamey"));
                // Note the Chooser below. If no applications match,
                // Android displays a system message.So here there is no need for try-catch.
                startActivity(Intent.createChooser(intent, "Browse with"));
            }
        });
        www.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ameypandit.xyz"));
                // Note the Chooser below. If no applications match,
                // Android displays a system message.So here there is no need for try-catch.
                startActivity(Intent.createChooser(intent, "Browse with"));
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","amey.pandit01@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ameypandit/"));
                // Note the Chooser below. If no applications match,
                // Android displays a system message.So here there is no need for try-catch.
                startActivity(Intent.createChooser(intent, "Browse with"));
            }
        });

        //Loading Image

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.linkedin);
        requestOptions.error(R.drawable.linkedin);

        Glide.with(AboutActivity.this)
                .load("https://raw.githubusercontent.com/panditamey/assetsstorage/main/pic.jpg")
                .apply(requestOptions)
                .into(ameypanditIV);
    }
}
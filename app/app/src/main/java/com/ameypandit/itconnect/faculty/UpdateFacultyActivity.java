package com.ameypandit.itconnect.faculty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ameypandit.itconnect.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateFacultyActivity extends AppCompatActivity {

    FloatingActionButton fab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFacultyActivity.this,AddTeacherActivity.class));
            }
        });

    }
}
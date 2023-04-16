package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ameypandit.itconnect.faculty.UpdateFacultyActivity;
import com.ameypandit.itconnect.notice.DeleteNoticeActivity;
import com.ameypandit.itconnect.notice.UploadNotice;
import com.ameypandit.itconnect.pdfreader.PdfActivity;


public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    Button uploadNotice ;
    Button addgalleryImage;
    Button uploadPdf;
    Button faculty;
    Button deleteNotice;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        uploadNotice = findViewById(R.id.up_notice);
        uploadNotice.setOnClickListener(this);

        addgalleryImage = findViewById(R.id.up_image);
        addgalleryImage.setOnClickListener(this);

        uploadPdf = findViewById(R.id.up_ebook);
        uploadPdf.setOnClickListener(this);

        faculty = findViewById(R.id.up_faculty);
        faculty.setOnClickListener(this);

        deleteNotice = findViewById(R.id.dlt_notice);
        deleteNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.up_notice:
                intent = new Intent(AdminActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.up_image:
                intent = new Intent(AdminActivity.this,UploadImage.class);
                startActivity(intent);
                break;
            case R.id.up_ebook:
                intent = new Intent(AdminActivity.this, PdfActivity.class);
                startActivity(intent);
                break;
            case R.id.up_faculty:
                intent = new Intent(AdminActivity.this, UpdateFacultyActivity.class);
                startActivity(intent);
                break;
            case R.id.dlt_notice:
                intent = new Intent(AdminActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
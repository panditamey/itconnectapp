package com.ameypandit.itconnect.pdfreader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ameypandit.itconnect.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPdfActivity extends AppCompatActivity {

    ListView pdfList;

    DatabaseReference databaseReference;
    List<uploadPdf> uploadPdfs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pdfList=findViewById(R.id.pdfList);

        uploadPdfs = new ArrayList<>();

        viewAllFiles();

        pdfList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                uploadPdf uploadPdf = uploadPdfs.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW) ;

                intent.setDataAndType(Uri.parse(uploadPdf.getUrl()),"application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

            }
        });
    }

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                    uploadPdf uploadPdf = postSnapshot.getValue(com.ameypandit.itconnect.pdfreader.uploadPdf.class);
                    uploadPdfs.add(uploadPdf);

                }

                String[] uploads = new String[uploadPdfs.size()];

                for (int i = 0 ; i<uploads.length;i++){
                    uploads[i] = uploadPdfs.get(i).getName();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploads);
                pdfList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
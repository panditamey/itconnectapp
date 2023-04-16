package com.ameypandit.itconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ameypandit.itconnect.ebook.EbookActivity;
import com.ameypandit.itconnect.notice.ViewNoticeActivity;
import com.ameypandit.itconnect.pdfreader.ViewPdfActivity;
import com.ameypandit.itconnect.ui.about.AboutFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private Button seit1 , seit2 , timeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        seit1=findViewById(R.id.seit1);
        seit2=findViewById(R.id.seit2);
        timeTable=findViewById(R.id.timeTable);

        seit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW) ;
                intent.setDataAndType(Uri.parse("https://firebasestorage.googleapis.com/v0/b/it-connect-a6f57.appspot.com/o/pdf%2FSEIT-1%20Roll%20List%20(2021-2022).pdf?alt=media&token=7abfd15f-554b-40b5-b645-beb880d29a35"),"application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        seit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW) ;
                intent2.setDataAndType(Uri.parse("https://firebasestorage.googleapis.com/v0/b/it-connect-a6f57.appspot.com/o/pdf%2FSEIT-2%20Roll%20List%20(2021-2022.pdf?alt=media&token=8e65b465-9fcb-4292-a554-faba16835e61"),"application/pdf");
                intent2.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent2);
            }
        });
        timeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW) ;
                intent3.setDataAndType(Uri.parse("https://firebasestorage.googleapis.com/v0/b/it-connect-a6f57.appspot.com/o/pdf%2FSEIT%20TT%203rd%20Sep%20Onwards.pdf?alt=media&token=1451625b-4c5e-4d0d-aa59-e84c716c6ca6"),"application/pdf");
                intent3.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent3);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.navigation_developer:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.navigation_video:
                Intent gotoVideoLectures = new Intent(MainActivity.this, LecturesActivity.class);
                startActivity(gotoVideoLectures);
                break;
            case R.id.navigation_notice:
                Intent Viewnotice = new Intent(MainActivity.this, ViewNoticeActivity.class);
                startActivity(Viewnotice);
                break;
            case R.id.navigation_ebook:
                Intent gotoebook = new Intent(MainActivity.this, ViewPdfActivity.class);
                startActivity(gotoebook);
                break;
            case R.id.navigation_share:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_faculty:
                Intent gotoFaculty = new Intent(MainActivity.this, FacultyActivity.class);
                startActivity(gotoFaculty);
                break;
            case R.id.navigation_admin:
                Toast.makeText(MainActivity.this, "Admin", Toast.LENGTH_SHORT).show();
                Intent admin = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(admin);
                break;
        }

        return true;
    }

    private void goToUrl (){
        Uri uriUrl = Uri.parse("http://www.google.com");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
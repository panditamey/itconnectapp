package com.ameypandit.itconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        sharedPreferences= this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();




        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sharedPreferences.getString("isLogin","false").equals("yes")){
                    Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },3000);

    }


}
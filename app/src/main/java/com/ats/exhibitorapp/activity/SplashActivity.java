package com.ats.exhibitorapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ats.exhibitorapp.R;
import com.ats.exhibitorapp.utils.AppPreferences;

public class SplashActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 1500;
    private AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        appPreferences=new AppPreferences(getApplicationContext());

    }


    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(appPreferences.isLoggedIn()) {
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }else{
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
            }
        }, SPLASH_TIME_OUT);

    }

}

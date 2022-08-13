package com.zainulrifqi.uasakbif_210119082;

// NIM   : 10119082
// Nama  : Zainul Rifqi Muwaffaq
// Kelas : IF2

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(splashScreen.this, LoginActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
package com.example.projekat_3_boris_evetovic;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread t = new Thread() {
            public void run() {
                try {
                    sleep(3000);

                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}

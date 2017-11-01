package com.bluez.test2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static int TIME_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread background = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(TIME_DELAY);

                    Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {

                }

            }
        };

        background.start();
    }
}

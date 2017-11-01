package com.bluez.test2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class HomeActivity extends AppCompatActivity {
    Button bn_happy, bn_sad;
    private static boolean isHappyAgain = false;
    private static boolean isSadAgain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bn_happy = (Button) findViewById(R.id.bn_happy);
        bn_sad = (Button) findViewById(R.id.bn_sad);

        bn_happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Happy happy = new Happy();
                if(!isHappyAgain) {
                    fragmentTransaction.replace(R.id.fragment_container, happy);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    isHappyAgain = true;
                    isSadAgain = false;
                }
            }
        });

        bn_sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Sad sad = new Sad();
                if(!isSadAgain) {
                    fragmentTransaction.replace(R.id.fragment_container, sad);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    isSadAgain = true;
                    isHappyAgain = false;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(currentFragment != null)
            getSupportFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }
}

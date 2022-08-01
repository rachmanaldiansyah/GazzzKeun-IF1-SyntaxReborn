package com.syntaxreborn.gazzzkeun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

//Identitas
//1. Reihan wiyanda - 10119011
//2. Rachman Aldiansyah - 10119038
//3. Diva Sabila Ramadhan - 10119039
//4. Rendy Dermawan- 10119030
//5. Adira Fahri Gathan - 10119025
// IF-1
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // menghilangkan actionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                finish();
            }
        }, 3000);
    }
}
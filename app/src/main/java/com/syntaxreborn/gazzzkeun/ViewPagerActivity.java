package com.syntaxreborn.gazzzkeun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

// Identitas
// NIM      : 10119038
// Nama     : Rachman Aldiansyah
// Kelas    : IF-1
public class ViewPagerActivity extends AppCompatActivity {

    androidx.viewpager.widget.ViewPager viewPager;
    int[] layouts;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // menghilangkan actionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.pager);

        layouts = new int[] {
                R.layout.viewpager_content1,
                R.layout.viewpager_content2,
                R.layout.viewpager_content3
        };

        adapter = new Adapter(this, layouts);
        viewPager.setAdapter(adapter);
    }

    public void goToMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
package com.syntaxreborn.gazzzkeun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

// Identitas
// NIM      : 10119038
// Nama     : Rachman Aldiansyah
// Kelas    : IF-1
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MapsFragment mapsFragment = new MapsFragment();
    AboutFragment aboutFragment = new AboutFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // menghilangkan actionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapsFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.maps:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, mapsFragment).commit();
                        return true;
                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

}
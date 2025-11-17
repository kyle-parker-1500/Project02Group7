package com.example.project02group7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView2);

        // Create fragment instances
        Fragment firstFragment = new HomeFragment();
        Fragment secondFragment = new RecipeFragment();
        Fragment thirdFragment = new AccountFragment();
        Fragment fourthFragment = new SettingFragment();

        // Set initial fragment
        setCurrentFragment(firstFragment);
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Handle bottom navigation selection using if–else (to avoid "constant expression required")
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                setCurrentFragment(firstFragment);
            } else if (id == R.id.recipe) {
                setCurrentFragment(secondFragment);
            } else if (id == R.id.profile) {
                setCurrentFragment(thirdFragment);
            } else if (id == R.id.setting) {
                setCurrentFragment(fourthFragment);
            }
            return true;
        });
    }

    // Helper method to switch fragments
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }

}
package com.example.phys8.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.phys8.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    NavHostFragment nav_fragment_main_menu;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        nav_fragment_main_menu = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.permainanFragment, R.id.profileFragment).build();
        navController = nav_fragment_main_menu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.berandaFragment || destination.getId() == R.id.permainanFragment || destination.getId() == R.id.profileFragment){
                bottomNavigationView.setVisibility(View.VISIBLE);

            }else {
                bottomNavigationView.setVisibility(View.GONE);
            }
        });

        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return nav_fragment_main_menu.getNavController().navigateUp()||super.onSupportNavigateUp();
    }
}
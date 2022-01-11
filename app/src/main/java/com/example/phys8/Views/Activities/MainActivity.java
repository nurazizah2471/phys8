package com.example.phys8.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.phys8.Helpers.SharedPreferenceHelper;
import com.example.phys8.Models.Level;
import com.example.phys8.Models.User;
import com.example.phys8.R;
import com.example.phys8.ViewModels.PermainanViewModel;
import com.example.phys8.ViewModels.ProfileViewModel;
import com.example.phys8.ViewModels.UserViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

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


       // helper = SharedPreferenceHelper.getInstance(this);
        //helper.saveUserId("1");

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.permainanFragment, R.id.profileFragment).build();
        navController = nav_fragment_main_menu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.profileFragment || destination.getId() == R.id.loginFragment
                    || destination.getId() == R.id.permainanFragment || destination.getId() == R.id.peringkatFragment || destination.getId()==R.id.historyFragment){


            }else {

            }
        });

        bottomNavigationView.setVisibility(View.GONE);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        return nav_fragment_main_menu.getNavController().navigateUp()||super.onSupportNavigateUp();
    }
}
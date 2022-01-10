package com.example.phys8.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
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
    CardView card_InfoUser;
    ProfileViewModel profileViewModel;
    private SharedPreferenceHelper helper;
    TextView ticket_amount, cash_amount, coin_amount, name_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card_InfoUser = findViewById(R.id.card_InfoUser);
        ticket_amount = findViewById(R.id.ticket_amount);
        cash_amount = findViewById(R.id.cash_amount);
        coin_amount = findViewById(R.id.coin_amount);
        name_user = findViewById(R.id.name_user);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        nav_fragment_main_menu = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_fragment_main_menu);
        profileViewModel=new ViewModelProvider(this).get(ProfileViewModel.class);

        helper = SharedPreferenceHelper.getInstance(this);
        helper.saveUserId("1");

        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.berandaFragment, R.id.permainanFragment, R.id.profileFragment).build();
        navController = nav_fragment_main_menu.getNavController();
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.profileFragment || destination.getId() == R.id.permainanFragment || destination.getId() == R.id.profileFragment){
                card_InfoUser.setVisibility(View.GONE);

            }else {
                card_InfoUser.setVisibility(View.VISIBLE);
            }
        });
        bottomNavigationView.setVisibility(View.GONE);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, configuration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        //userViewModel.init(helper.getAccessToken()); unsend
        profileViewModel.getUserWithId(helper.getUserId());
        profileViewModel.getResultUserWithId().observe(this, showResultUserInfo);
    }

    private Observer<User.Result> showResultUserInfo = new Observer<User.Result>() {
        @Override
        public void onChanged(User.Result results) {
            if(results.getUsername().length()>5) {
                name_user.setText(String.valueOf(results.getUsername().subSequence(0, 5)+"..."));
            }else {
                name_user.setText(String.valueOf(results.getUsername()));
            }
            cash_amount.setText(String.valueOf(results.getMyuser().getMoney()));
            ticket_amount.setText(String.valueOf(results.getMyuser().getTicket()));
            coin_amount.setText(String.valueOf(results.getMyuser().getScore()));
        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        return nav_fragment_main_menu.getNavController().navigateUp()||super.onSupportNavigateUp();
    }
}
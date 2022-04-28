package com.example.helloworld;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.helloworld.databinding.HomePageBinding;

public class HomePage extends AppCompatActivity {//Contains three frogments:home, parkhistory, userCenter

    private HomePageBinding binding;
    private static ActivityCollectUtil activityCollectUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//this关键字用于指向调用它的对象，即本activity
        //用于logout时finishAllActivity

        binding = HomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_userCenter, R.id.navigation_parkHistory)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);



    }

}
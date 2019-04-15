package com.example.iexpens;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemReselectedListener(this);

        loadFragment(new HomeFragment());

    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();

        }

    }

    public void onNavigationItemReselected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {

                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    break;

                case R.id.navigation_wallet:
                    fragment = new WalletFragment();
                    break;

                case R.id.navigation_overview:
                    fragment = new OverviewFragment();
                    break;

                case R.id.navigation_notifications:
                    fragment = new NotificationFragment();
                    break;
            }

        loadFragment(fragment);
    }
}
package com.example.navigation_bott;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigation = findViewById(R.id.bottom_navigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_notification));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_info));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;
                switch (item.getId())
                {
                    case 1:
                        fragment = new NotificationFragment();
                        break;
                    case 2:
                        fragment = new HomeFragment();
                        break;
                    case 3:
                        fragment = new InfoFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        bottomNavigation.setCount(1,"10");
        bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

                Toast.makeText(getApplicationContext(), "You Click ", Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

                Toast.makeText(getApplicationContext(), "You RE-Click ", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.share)
        {
            Toast.makeText(getApplicationContext(),"You Click Share", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.exit)
        {
            Toast.makeText(getApplicationContext(),"You Click Exit", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.search)
        {
            Toast.makeText(getApplicationContext(),"You Click Search", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.setting)
        {
            Toast.makeText(getApplicationContext(),"You Click Setting", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.about)
        {
            Toast.makeText(getApplicationContext(),"You Click About", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }
}
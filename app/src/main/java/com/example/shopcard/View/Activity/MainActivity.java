package com.example.shopcard.View.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shopcard.R;
import com.example.shopcard.View.Fragment.AccountFragment;
import com.example.shopcard.View.Fragment.CardFragment;
import com.example.shopcard.View.Fragment.HomeFragment;
import com.example.shopcard.View.Fragment.LikeFragment;
import com.example.shopcard.View.Fragment.NotificatinFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //  load the home fragment by default
        LoadFragment(new HomeFragment(),0);

        bottomNavigationView =findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.home){
                       LoadFragment(new HomeFragment(),1);
                } else if (id==R.id.like) {
                    LoadFragment(new LikeFragment(),1);

                } else if (id==R.id.order) {
                    LoadFragment(new CardFragment(),1);
                } else if (id==R.id.notification) {
                    LoadFragment(new NotificatinFragment(),1);
                }else {
                    LoadFragment(new AccountFragment(),1);
                }

                return true;
            }
        });





    }
    public  void  LoadFragment(Fragment fragment,int i){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(i==0){
            ft.add(R.id.fragmentContainer ,fragment);
        }else{
            ft.replace(R.id.fragmentContainer , fragment);
        }

        ft.commit();

    }

}
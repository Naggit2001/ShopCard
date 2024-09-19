package com.example.shopcard.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shopcard.R;

public class WellcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wellcome_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
                Boolean is_present = sharedPreferences.getBoolean("flag",false );


                if(is_present){
                    Intent intent = new Intent(WellcomeScreenActivity.this ,MainActivity.class);
                    startActivity(intent);
                    finish();

                }else {
                    Intent intent = new Intent(WellcomeScreenActivity.this ,OnboardActivity.class);
                    startActivity(intent);
                    finish();

                }


            }
        },3000);




    }
}
package com.example.shopcard.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shopcard.Controler.LoginController;
import com.example.shopcard.R;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    TextView  createAccount ;
    EditText username , password ;
    Button  loginBtn , loginGoogleBtn;
    LoginController loginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        createAccount =findViewById(R.id.createaccount);
        loginBtn = findViewById(R.id.login);
        username=findViewById(R.id.username);
        password =findViewById(R.id.password);


        loginController =new LoginController(this);



        //   go to account  create  page
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , SignUpActivity.class));
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.isEmpty() || pass.isEmpty()){
                    Toast.makeText(LoginActivity.this ,"place insert username and password",Toast.LENGTH_LONG).show();
                }else {
                    boolean success = loginController.performLogin(user,pass);
                    if(success){


                        // if the  user is  login success
                        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putBoolean("flag",true);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this ,MainActivity.class));
                        finish();

                    }else {
                        Toast.makeText(LoginActivity.this ,"Invalid username & password " ,Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });



    }
}
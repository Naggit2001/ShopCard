package com.example.shopcard.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopcard.Controler.SignUpController;
import com.example.shopcard.Controler.SignUpController;
import com.example.shopcard.R;

public class SignUpActivity extends AppCompatActivity {
    private TextView movelogin;
    private Button loginBtn, loginGoogleBtn;
    private EditText name, username, password;

    private SignUpController signUpController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        movelogin = findViewById(R.id.loginpage);
        loginBtn = findViewById(R.id.login);
        loginGoogleBtn = findViewById(R.id.loginGoogle);
        name = findViewById(R.id.nameSign);
        username = findViewById(R.id.usernameSign);
        password = findViewById(R.id.passwordSign);

        signUpController = new SignUpController(this);

        // Go back to login page
        movelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                finish();
            }
        });

        // Handle SignUp button click
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userUsername = username.getText().toString();
                String userPassword = password.getText().toString();

                if (userName.isEmpty() || userUsername.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    boolean success = signUpController.performSignUp(userName, userUsername, userPassword);
                    if (success) {
                        Toast.makeText(SignUpActivity.this, "SignUp successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "SignUp failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

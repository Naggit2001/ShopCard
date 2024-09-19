package com.example.shopcard.Controler;

import android.content.Context;
import android.database.Cursor;

import com.example.shopcard.Model.DatabaseHelper;
import com.example.shopcard.Model.UserModel;

public class SignUpController {

    private DatabaseHelper databaseHelper ;

    public  SignUpController(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    public boolean performSignUp(String name, String username, String password) {
        Cursor cursor = databaseHelper.getUser(username);

        if (cursor.getCount() > 0) {
            return false; // User already exists
        } else {
            UserModel user = new UserModel(name, username, password);
            long result = databaseHelper.addUser(user);
            return result != -1; // Success if result is not -1
        }
    }




}

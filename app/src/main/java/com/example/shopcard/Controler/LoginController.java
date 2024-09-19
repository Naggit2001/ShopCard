package com.example.shopcard.Controler;

import android.content.Context;
import android.database.Cursor;

import com.example.shopcard.Model.DatabaseHelper;

public class LoginController {
    DatabaseHelper databaseHelper ;


    public LoginController(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }

    public  boolean performLogin(String username ,String password){
        Cursor cursor = databaseHelper.getUser(username);
        if(cursor.moveToNext()){
            String storePassword = cursor.getString(cursor.getColumnIndexOrThrow("password"));

            return storePassword.equals(password);
        }


        return  false;
    }

}

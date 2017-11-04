package com.example.gilkr.sharetask;


import android.util.Log;

import com.parse.LogInCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by gilkr on 11/4/2017.
 */

@ParseClassName("User")
public class User extends ParseObject {
    Boolean verifyUserLogin;
    Boolean userSignUpResult;

    public Boolean CreateUser(String userName, String password, String email) {
        userSignUpResult = null;
        ParseUser newUser = new ParseUser();
        newUser.setUsername(userName);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e!=null) {
                    userSignUpResult = true;
                }else {
                    userSignUpResult = false;
                }
            }
        });
        while (userSignUpResult == null) {}
        return userSignUpResult;
    }


    public Boolean VerifyUser(String userName, String password) {
        try {
            ParseUser user = ParseUser.logIn(userName, password);
            if (user==null) {
                verifyUserLogin = false;
            } else {
                verifyUserLogin = true;
            }
        } catch (Exception e) {

            // generic exception handling
            //e.printStackTrace();
            Log.e("MYAPP", "exception", e);
            return false;
        }
        return verifyUserLogin;
    }
}

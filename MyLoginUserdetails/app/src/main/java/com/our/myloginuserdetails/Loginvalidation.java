package com.our.myloginuserdetails;

import android.util.Log;
import android.util.Patterns;

public class Loginvalidation {
    public static final String  TAG=Loginvalidation.class.getName();

    String email,password;

    /**
     * creating constuctor
     * @param email
     * @param password
     */

    public Loginvalidation(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // for getting email address
    public String getemail(){
        return email;
    }
    // getting password
    public String getPassword(){
        return email;
    }

    /**
     * for check user enter the correct details or not
     * @return
     */
    public int loginCheck(){
        Log.d(TAG,"Checking the login user email and password");

        if (Patterns.EMAIL_ADDRESS.matcher(getemail()).matches()|| getPassword().length()<=6){
            return 1;
        }
        Log.d(TAG,"Checking the login user email and password miss match");
        return 0;
    }
}

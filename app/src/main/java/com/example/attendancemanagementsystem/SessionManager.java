package com.example.attendancemanagementsystem;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    private SharedPreferences pref;

    private SharedPreferences.Editor editor;
    private Context _context;

    // Shared pref mode
    private int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "attendancemanagementsystem";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    private static final String KEY_IS_CAR_FOUND = "isCarFound";

    private static final String KEY_USER_ID = "USERID";


    private static final String KEY_USER_NAME = "USERNAME";




    private static final String TAG_TOKEN = "tagtoken";


    private static final String password_TAG = "password";




    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.apply();
    }

    public void setLogin(boolean isLoggedIn, int userID) {


        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.putInt(KEY_USER_ID, userID);
//        editor.putString(KEY_USER_NAME, userName);
//        editor.putString(password_TAG,password);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }




    public void setUserName(String username){
        editor.putString(KEY_USER_NAME, username);
        // commit changes
        editor.commit();
    }

    public int getUserId(){
        return pref.getInt(KEY_USER_ID, 0);
    }






    public String getUserName() {
        return pref.getString(KEY_USER_NAME, "empty");
    }



    //this method will save the device token to shared preferences
    public boolean saveDeviceToken(String token){
//        SharedPreferences sharedPreferences = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG_TOKEN, token);
        // commit changes
        editor.commit();
        return true;
    }

    //this method will fetch the device token from shared preferences
    public String getDeviceToken(){
      //  SharedPreferences sharedPreferences = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return  pref.getString(TAG_TOKEN, "empty");
    }



    public  String getPassword_TAG() {
        return   pref.getString(password_TAG,"empty");
    }


    public void setPassword_TAG(String password_TAG){
        editor.putString(password_TAG,password_TAG);
        editor.commit();
    }

}

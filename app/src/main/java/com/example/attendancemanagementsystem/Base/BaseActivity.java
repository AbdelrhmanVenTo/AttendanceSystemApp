package com.example.attendancemanagementsystem.Base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;


public class BaseActivity extends AppCompatActivity {

    MaterialDialog dialog;
    protected BaseActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
    }



    public MaterialDialog showMessageString(String title,String message,String posText){

        dialog= new MaterialDialog.Builder(this)
                .title(title)
                .content(message)
                .positiveText(posText)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return dialog;
    }

    public MaterialDialog showMessageInt(int titleResId,int messageResId,int posResText){

        new MaterialDialog.Builder(this)
                .title(titleResId)
                .content(messageResId)
                .positiveText(posResText)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
        return dialog;
    }

    public MaterialDialog showConfirmationMessageInt(int titleResId,
                                                     int contentResId,
                                                     int posTextResId,
                                                     MaterialDialog.SingleButtonCallback onPos
    ){
        dialog= new MaterialDialog.Builder(this)
                .title(titleResId)
                .content(contentResId)
                .positiveText(posTextResId)
                .onPositive(onPos)
                .show();
        return dialog;
    }

    public MaterialDialog showConfirmationMessageString(String titleResId,
                                                        String contentResId,
                                                        String posTextResId,
                                                        MaterialDialog.SingleButtonCallback onPos
    ){
        dialog= new MaterialDialog.Builder(this)
                .title(titleResId)
                .content(contentResId)
                .positiveText(posTextResId)
                .onPositive(onPos)
                .show();
        return dialog;
    }


    public MaterialDialog showProgressBar(int titleResId, int contentResId){
        dialog= new MaterialDialog.Builder(this)
                .title(titleResId)
                .content(contentResId)
                .progress(true,0)
                .cancelable(false)
                .show();
        return dialog;
    }

    public void hideProgressBar(){
        if(dialog!=null&&dialog.isShowing())
            dialog.dismiss();
    }

     /*public void saveStringValue(String userName, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences("AMS", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", userName);
        editor.putString("Password", password);
        editor.apply();
    }*/

    public void rememberMe(String user, String password){
        //save username and password in SharedPreferences
        getSharedPreferences("AMS",MODE_PRIVATE)
                .edit()
                .putString("userName",user)
                .putString("Password",password)
                .apply();
    }

    public void getUser(){
        SharedPreferences pref = getSharedPreferences("AMS",MODE_PRIVATE);
        String username = pref.getString("userName", null);
        String password = pref.getString("Password", null);

    }

    public void saveStringValue(String key,String value){
        SharedPreferences.Editor editor=
                getSharedPreferences("AMS",MODE_PRIVATE)
                        .edit();
        editor.putString(key,value);
        editor.apply();

    }
    public String getStringValue(String key){
        SharedPreferences sharedPreferences= getSharedPreferences("AMS",
                MODE_PRIVATE);
        return sharedPreferences.getString(key,null);
    }


    public void clearStringValue (String key){

        SharedPreferences.Editor editor =
                getSharedPreferences("AMS", MODE_PRIVATE)
                        .edit();

        editor.remove(key);

        editor.apply();
    }


    /*public String getUser(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString("userName", "");
    }
    public String getPassword(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString("password", "");
    }*/



}

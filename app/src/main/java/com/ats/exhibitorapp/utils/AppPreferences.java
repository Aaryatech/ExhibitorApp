package com.ats.exhibitorapp.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.ats.exhibitorapp.activity.LoginActivity;
import com.ats.exhibitorapp.model.Employee;
import com.google.gson.Gson;

public class AppPreferences {

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private Context context;

    private int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "appPref";

    private static final String KEY_IS_LOGIN = "isLoggedIn";

    private static final String KEY_LOGIN_EMP = "employee";


    public AppPreferences(Context context) {
        this.context = context;
    }

    public void createLoginEntry(Employee employee) {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

        Gson gson = new Gson();
        String json = gson.toJson(employee);

        editor.putBoolean(KEY_IS_LOGIN, true);
        editor.putString(KEY_LOGIN_EMP, json);
        editor.apply();
    }

    public boolean isLoggedIn() {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        return pref.getBoolean(KEY_IS_LOGIN, false);
    }

    public Employee getLoggedInEmp() {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        Gson gson = new Gson();
        String json = pref.getString(KEY_LOGIN_EMP, "");

        return gson.fromJson(json, Employee.class);
    }

    public void logoutEmp(){

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.clear();
        editor.apply();

        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }

}

package com.netflix.app.utlis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.netflix.app.home.ui.Home_Activity;
import com.netflix.app.loginregister.User;

public class BaseActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public DatabaseReference UserInstance = FirebaseDatabase.getInstance().getReference("Users");
    public DatabaseReference UserDataInstance = FirebaseDatabase.getInstance().getReference("UserData");

    private SharedPreferences getPrefData(Context context) {
        return context.getSharedPreferences("Netflix", Context.MODE_PRIVATE);

    }
    private String getPref(Context context, String key){
        return getPrefData(context).getString(key, "null");
    }

    public void setPref(Context context, String key, String value){
        SharedPreferences.Editor editor = getPrefData(context).edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void showProgressDialog() {
        if (!isFinishing()) {
            ProgressActivity.showDialog(this);
        }
    }

    public void dismissProgressDialog() {
        if (!isFinishing()) {
            ProgressActivity.dismissDialog();
        }
    }


    public void snackBar(View constraintlayout, String s)
    {
        Snackbar snackbar = Snackbar.make(constraintlayout, s.toUpperCase(), Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public  void retriveUserDetails(FirebaseUser fUser){
        UserInstance.child(fUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if(user !=null)
                    saveDetails(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void saveDetails(User user) {
        dismissProgressDialog();
        startActivity(new Intent(this, Home_Activity.class));
        finish();
        sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("Id", user.getId());
        editor.putString("Name", user.getName());
        editor.putString("Email", user.getEmail());
        editor.putString("Phone", user.getPhone());
        editor.putString("gmail", user.getGmail());
        editor.putString("mobileCode", user.getMobilecode());
        editor.apply();

    }

    public void saveLoginDetails(String email, String password){


        sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        {
            editor = sharedPreferences.edit();
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.commit();

        }
    }
}

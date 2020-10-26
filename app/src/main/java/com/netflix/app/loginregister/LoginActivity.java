package com.netflix.app.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.netflix.app.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {
    TextView Tv_Signup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Tv_Signup = findViewById(R.id.Tv_Signup);
        Tv_Signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())

        {
            case R.id.Tv_Signup:
                Intent loginintent = new Intent(this,RegisterActivity.class);
                startActivity(loginintent);
                break;

        }
    }
}

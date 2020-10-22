package com.netflix.app.drawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.netflix.app.R;

public class Dialog_Pay_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog__pay_);
        String[] descriptionData = {"Plans", "Sign In", "Pay", "Watch"};

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.state_progress_id);
        stateProgressBar.setStateDescriptionData(descriptionData);
    }
}
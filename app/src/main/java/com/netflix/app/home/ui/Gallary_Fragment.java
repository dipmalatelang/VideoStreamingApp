package com.netflix.app.home.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.netflix.app.R;
import com.netflix.app.sdksample.ui.InitAuthSDKActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Gallary_Fragment extends Fragment {

    public Gallary_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallary, container, false);
        ImageView videocall =v.findViewById(R.id.videocall);
        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videointent = new Intent(getContext(), InitAuthSDKActivity.class);
                startActivity(videointent);
            }
        });
        return  v;
    }
}

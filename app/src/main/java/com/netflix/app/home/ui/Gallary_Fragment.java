package com.netflix.app.home.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.netflix.app.R;

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
        return inflater.inflate(R.layout.fragment_gallary, container, false);
    }
}

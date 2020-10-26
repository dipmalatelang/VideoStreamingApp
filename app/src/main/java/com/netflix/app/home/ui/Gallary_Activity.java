package com.netflix.app.home.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.netflix.app.R;
import com.netflix.app.home.adapter.GallaryAdapter;

public class Gallary_Activity extends AppCompatActivity {
    RecyclerView recyclerView_gallary;
    GallaryAdapter gallaryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_);
        recyclerView_gallary = findViewById(R.id.recyclerView_gallary);
//        gallaryAdapter = new GallaryAdapter(Gallary_Activity.this, );
//        recyclerView_gallary.setAdapter(gallaryAdapter);
//        recyclerView_gallary.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));


    }
}

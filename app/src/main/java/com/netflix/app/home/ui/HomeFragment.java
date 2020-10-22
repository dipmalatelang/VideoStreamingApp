package com.netflix.app.home.ui;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.transition.Slide;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.toolbox.ImageLoader;
import com.google.android.material.slider.Slider;
import com.google.android.material.tabs.TabLayout;
import com.netflix.app.R;
import com.netflix.app.home.adapter.MovieAdapter;
import com.netflix.app.home.adapter.MovieItemClickListener;
import com.netflix.app.home.adapter.SliderPagerAdapter;
import com.netflix.app.home.model.MovieData;
import com.netflix.app.home.model.SlideData;
import com.netflix.app.utlis.ApiCall;
import com.netflix.app.utlis.ApiInterface;
import com.netflix.app.utlis.DataSources;
import com.netflix.app.utlis.SlidePojo;
import com.netflix.app.utlis.SliderData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.simpleframework.xml.stream.Position;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class HomeFragment extends Fragment implements MovieItemClickListener {
    private List<SlideData> lstSlides;
    private List<SliderData> list;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView movie_recyclerview;
    private TextView Tv_seeall;
    private List<SlidePojo> Imgslide;

    SliderPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.h_fragment_home_, container, false);

        iniViews(view);
        InMovies();
        getSliderData();


        Tv_seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment someFragment = new HomeVideoPlay_Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.rl_fragment_container, someFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });

        return view;
    }

    private void InMovies() {
        MovieAdapter movieAdapter = new MovieAdapter(getContext(), DataSources.getmovie(), HomeFragment.this);
        movie_recyclerview.setAdapter(movieAdapter);
        movie_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }
    private void iniViews(View view) {
        sliderpager = view.findViewById(R.id.sliderpager);
        indicator = view.findViewById(R.id.indicator);
        movie_recyclerview = view.findViewById(R.id.movie_recyclerview);
        Tv_seeall = view.findViewById(R.id.Tv_seeall);
    }


    public void onMovieClick(MovieData movie, ImageView movieImageView) {


        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        // send movie information to deatilActivity
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());
        // lets crezte the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) getContext(),
                movieImageView, "sharedName");

        startActivity(intent, options.toBundle());
        // i l make a simple test to see if the click works
        Toast.makeText(getContext(), "item clicked : " + movie.getTitle(), Toast.LENGTH_LONG).show();
        // it works great

    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (sliderpager.getCurrentItem() < Imgslide.size() - 1) {

                            sliderpager.setCurrentItem(sliderpager.getCurrentItem() + 1);
                        } else
                            sliderpager.setCurrentItem(0);
                    }
                });
            }
        }
    }

     //getSliderDataAPiforslideimage
    public void getSliderData() {
        String slider = "slide";
        ApiInterface apiInterface = ApiCall.getApiData().create(ApiInterface.class);
        Call<List<SlidePojo>> call = apiInterface.getSlideData(slider);
        call.enqueue(new Callback<List<SlidePojo>>() {
            @Override
            public void onResponse(Call<List<SlidePojo>> call, Response<List<SlidePojo>> response) {
                if (response.code() ==200){
                    for(int i=0;i<response.body().size();i++)
                    {
                        Log.d(TAG, "onResponsesizeofjsondata: "+response.body().size());
                        Imgslide =response.body();
                        adapter = new SliderPagerAdapter(getContext(),Imgslide);
                        sliderpager.setAdapter(adapter);
                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new SliderTimer(), 5000, 6000);
                        indicator.setupWithViewPager(sliderpager, true);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<SlidePojo>> call, Throwable t) {

            }
        });


    }


}

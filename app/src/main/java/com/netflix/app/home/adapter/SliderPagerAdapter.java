package com.netflix.app.home.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.netflix.app.R;
import com.netflix.app.utlis.SlidePojo;


import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<SlidePojo> list;
    private LayoutInflater layoutInflater;



    public SliderPagerAdapter(Context mContext, List<SlidePojo> list)
    {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_item,null);
        ImageView img = view.findViewById(R.id.slide_img);
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
        ProgressBar progressbar = view.findViewById(R.id.progressbar);
        progressbar.setVisibility(View.GONE);
        Glide.with(mContext).load(list.get(position).getThumbnail()).into(img);
//        Glide.with(mContext).load(list.get(position).getThumbnail()).addListener(new RequestListener<Drawable>() {
//            @Override
//            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                progressbar.setVisibility(View.GONE);
//                floatingActionButton.setVisibility(View.VISIBLE);
//
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                progressbar.setVisibility(View.GONE);
//                floatingActionButton.setVisibility(View.VISIBLE);

//                return false;
//            }
//        }).into(img);
        ViewPager viewPager=(ViewPager)container;
        viewPager.addView(view);
        return view;


    }
    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager)container;
        View view=(View)object;
        viewPager.removeView(view);

    }
}

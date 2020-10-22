package com.netflix.app.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.toolbox.ImageLoader;
import com.netflix.app.R;
import com.netflix.app.home.model.SlideData;
import com.netflix.app.utlis.SlidePojo;
import com.netflix.app.utlis.SliderData;
import com.squareup.picasso.Picasso;

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
        View view=layoutInflater.inflate(R.layout.slide_item,null);
        ImageView img=view.findViewById(R.id.slide_img);
        Picasso.with(mContext).load(list.get(position).getThumbnail()).into(img);

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

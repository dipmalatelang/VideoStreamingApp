package com.netflix.app.home.adapter;

import android.widget.ImageView;

import com.netflix.app.home.model.MovieData;

public interface MovieItemClickListener {

    void onMovieClick(MovieData movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}

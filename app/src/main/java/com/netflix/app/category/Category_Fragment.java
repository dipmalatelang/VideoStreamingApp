package com.netflix.app.category;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.netflix.app.R;
import com.netflix.app.category.adapter.CategoryAdapter;
import com.netflix.app.utlis.DataSources;


public class Category_Fragment extends Fragment {
    RecyclerView allcategory_recyclerview;
   private Toolbar toolbar_cat;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.c_fragment_category, container, false);
        allcategory_recyclerview = view.findViewById(R.id.allcategory_recyclerview);
        toolbar_cat = view.findViewById(R.id.toolbar_cat);
//        toolbar_cat.inflateMenu(R.menu.appbar_search_menu);

        iniAllCategory();

        return view;
    }
//    @Override
//    public void onPrepareOptionsMenu(Menu menu) {
//        MenuItem mSearchMenuItem = menu.findItem(R.id.ic_search);
//        SearchView searchView = (SearchView) mSearchMenuItem.getActionView();
//
//
//    }


    private void iniAllCategory() {
        CategoryAdapter categoryAdapter = new CategoryAdapter(getContext(), DataSources.getmovie());
        allcategory_recyclerview.setAdapter(categoryAdapter);
        allcategory_recyclerview.setLayoutManager(new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false));
    }


}

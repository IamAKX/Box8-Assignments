package com.akashapplications.assignment2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akashapplications.assignment2.R;
import com.akashapplications.assignment2.adapter.MenuAdapter;
import com.akashapplications.assignment2.model.MenuModel;
import com.akashapplications.assignment2.utilities.FillMenu;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wraps extends Fragment {


    MenuAdapter adapter;
    ArrayList<MenuModel> list = new ArrayList<>();
    RecyclerView recyclerView;

    public Wraps() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wraps, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.homeRecyclerView);
        list = new FillMenu(getActivity(),"wraps.json").fillArrayList();
        adapter = new MenuAdapter(getContext(),list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(25);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.invalidate();

    }

}

package com.akashapplications.assignment2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.akashapplications.assignment2.model.CategoryModel;

import java.util.ArrayList;

/**
 * Created by pratidhi on 13/9/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private Context context;
    private ArrayList<CategoryModel> categoryList;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder {
    }
}

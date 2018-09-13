package com.akashapplications.assignment2.utilities;

import com.akashapplications.assignment2.R;
import com.akashapplications.assignment2.model.CategoryModel;

import java.util.ArrayList;

public class FillCategory {
    public static ArrayList<CategoryModel> getList()
    {
        ArrayList<CategoryModel> list = new ArrayList<>();

        CategoryModel model = new CategoryModel();
        model.setName("Fusion Box");
        model.setDesc("");
        model.setImageId(R.drawable.cat_2);
        list.add(model);


        model = new CategoryModel();
        model.setName("Curries");
        model.setDesc("");
        model.setImageId(R.drawable.cat_3);
        list.add(model);

        model = new CategoryModel();
        model.setName("Biryani");
        model.setDesc("");
        model.setImageId(R.drawable.cat_4);
        list.add(model);

        model = new CategoryModel();
        model.setName("Wraps");
        model.setDesc("");
        model.setImageId(R.drawable.cat_5);
        list.add(model);

        model = new CategoryModel();
        model.setName("Ice Cream");
        model.setDesc("");
        model.setImageId(R.drawable.cat_6);
        list.add(model);

        model = new CategoryModel();
        model.setName("Box8");
        model.setDesc("");
        model.setImageId(R.drawable.cat_1);
        list.add(model);

        return list;
    }
}

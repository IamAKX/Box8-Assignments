package com.akashapplications.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.akashapplications.assignment2.adapter.CategoryAdapter;
import com.akashapplications.assignment2.model.CategoryModel;
import com.akashapplications.assignment2.utilities.FillCategory;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    SliderLayout sliderLayout;
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    ArrayList<CategoryModel> categoryList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.THIN_WORM); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        recyclerView = findViewById(R.id.recyclerview);

        categoryList = FillCategory.getList();
        setSliderViews();
        initRecycler();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/002/883/original/GC-----Web.jpg?1536814612");
                    break;
                case 1:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/003/175/original/2---Web-banner.jpg?1536735023");
                    break;
                case 2:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/003/001/original/1425X500_%281%29.jpg?1535798105");
                    break;
                case 3:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/002/968/original/Biryani-web.jpg?1536556215");
                    break;
                case 4:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/001/650/original/1425x500.jpg?1535778213");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("");
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://box8.in/category"));
                    startActivity(browserIntent);
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    private void initRecycler() {
        adapter = new CategoryAdapter(getBaseContext(),categoryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(25);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        GridLayoutManager staggeredGridLayoutManager = new GridLayoutManager(getBaseContext(),2);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.invalidate();
    }
}

package com.akashapplications.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class Home extends AppCompatActivity {
    SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.THIN_WORM); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();
    }

    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://assets.box8.co.in/picture_resolutions/photos/000/003/147/original/8-pass-web-banner_%281%29.jpg?1536761084");
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
                    Toast.makeText(Home.this, "Box8 Assignment2", Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}

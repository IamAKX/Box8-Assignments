package com.akashapplications.assignment2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.akashapplications.assignment2.fragments.Biryani;
import com.akashapplications.assignment2.fragments.Curries;
import com.akashapplications.assignment2.fragments.FusionBox;
import com.akashapplications.assignment2.fragments.IceCream;
import com.akashapplications.assignment2.fragments.Offers;
import com.akashapplications.assignment2.fragments.Wraps;
import com.github.juanlabrador.badgecounter.BadgeCounter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Menu extends AppCompatActivity {
    private SmartTabLayout viewPagerTab;
    public static ViewPager viewPager;
    static android.view.Menu cartMenu;
    public static int cartQty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Fusion Box", FusionBox.class)
                .add("Curries", Curries.class)
                .add("Biryani", Biryani.class)
                .add("Wraps", Wraps.class)
                .add("Ice Cream", IceCream.class)
                .add("Box8 Offers", Offers.class)
                .create());
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);


        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        viewPager.setCurrentItem(getIntent().getIntExtra("position",0));

    }

    public static void updateCart()
    {
        MenuItem item = cartMenu.findItem(R.id.notification);
        BadgeCounter.update(item, cartQty);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        BadgeCounter.update(this,
                menu.findItem(R.id.notification),
                R.drawable.cart,
                cartQty);
        cartMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cartQty = 0;
    }
}

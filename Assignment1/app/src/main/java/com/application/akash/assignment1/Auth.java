package com.application.akash.assignment1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.application.akash.assignment1.fragments.Login;
import com.application.akash.assignment1.fragments.Register;
import com.application.akash.assignment1.utilities.LocalPreference;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Auth extends AppCompatActivity {
    private SmartTabLayout viewPagerTab;
    public static ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Login", Login.class)
                .add("Register", Register.class)
                .create());


        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);


        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewPageTab);
        viewPagerTab.setViewPager(viewPager);

        if(checkLogin())
        {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("You are still logged in!")
                    .setContentText("Do you want to kill the session and start new one?")
                    .setConfirmText("Log out")

                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog
                                    .setTitleText("Success!")
                                    .setContentText("You have logged out!")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(null)
                                    .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                            LocalPreference p = new LocalPreference(getBaseContext());
                            p.setLoginStatus(false);
                        }
                    })
                    .show();
        }
    }

    private boolean checkLogin() {
        LocalPreference p = new LocalPreference(getBaseContext());
        return p.getLoginStatus();
    }
}

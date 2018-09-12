package com.akashapplications.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                // Now change the color back. Needs to be done on the UI thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        startActivity(new Intent(getBaseContext(),Home.class));
                        finish();
                    }
                });
            }
        }).start();
    }
}

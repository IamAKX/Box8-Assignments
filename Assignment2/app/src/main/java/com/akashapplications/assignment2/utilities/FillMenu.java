package com.akashapplications.assignment2.utilities;

import android.app.Activity;
import android.widget.Toast;

import com.akashapplications.assignment2.model.MenuModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FillMenu {
    Activity activity;
    String fileName;

    public FillMenu(Activity activity, String fileName) {
        this.activity = activity;
        this.fileName = fileName;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = activity.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<MenuModel> fillArrayList() {
        ArrayList<MenuModel> list = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray array = object.getJSONArray("data");
            for(int i = 0; i< array.length(); i++)
            {
                JSONObject o = array.getJSONObject(i);
                MenuModel m = new MenuModel();
                m.setImage(o.getString("image"));
                m.setTitle(o.getString("title"));
                m.setDescriptio(o.getString("description"));
                m.setAmount(o.getString("amount"));
                m.setVeg(o.getBoolean("isVeg"));
                m.setQuantity(0);

                list.add(m);
            }

        } catch (JSONException e) {

        }
        return list;
    }
}

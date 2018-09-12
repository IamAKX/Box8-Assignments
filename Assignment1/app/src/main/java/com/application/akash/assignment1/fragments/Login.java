package com.application.akash.assignment1.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.application.akash.assignment1.Home;
import com.application.akash.assignment1.R;
import com.application.akash.assignment1.utilities.LocalPreference;
import com.rengwuxian.materialedittext.MaterialEditText;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {


    public Login() {
        // Required empty public constructor
    }

    MaterialEditText email,password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        email = getView().findViewById(R.id.loginEmail);
        password = getView().findViewById(R.id.loginPassword);

        getView().findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(authenticate())
                {
                    new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Success")
                            .setContentText("You have logged in! Your session is preserved.")
                            .show();


                }
                else
                {
                    new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Oops!")
                            .setContentText("You have entered wrong credentials")
                            .show();
                }
            }
        });

    }

    private boolean authenticate() {
        LocalPreference p = new LocalPreference(getContext());

        if((p.getEmail().equals(email.getText().toString()) && p.getPassword().equals(password.getText().toString())) || (p.getphone().equals(email.getText().toString()) && p.getPassword().equals(password.getText().toString())))
        {
            p.setLoginStatus(true);
            return true;
        }

        return false;
    }
}

package com.kisan.kisan_android;

import android.os.Bundle;

import android.os.StrictMode;

import com.kisan.kisan_android.ui.main.BackGroundTask.ContactDisplayDao;
import com.kisan.kisan_android.ui.main.BackGroundTask.Database;
import com.kisan.kisan_android.ui.main.ContactModel;
import com.kisan.kisan_android.ui.main.HomeFragment;
import com.kisan.kisan_android.ui.main.SuperActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends SuperActivity {
    List<ContactModel> contactModelList = new ArrayList<ContactModel>();
    ContactDisplayDao contactDisplayDao;
    Executor executor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        gotoFragment(new HomeFragment(),null,"",this);
    }
}
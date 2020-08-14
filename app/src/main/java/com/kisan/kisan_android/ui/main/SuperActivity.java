package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.kisan.kisan_android.MainActivity;
import com.kisan.kisan_android.R;

public class SuperActivity extends AppCompatActivity {

    public void gotoFragment(Fragment fragment, Bundle bundle, String backStackTag, Context activity) {
        try {
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(0, 0);
            if (activity instanceof MainActivity) {
                fragmentTransaction.replace(R.id.frame_main, fragment);
            }
            if (CommonUtil.isValidString(backStackTag)) {
                fragmentTransaction.addToBackStack(backStackTag);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }
    }
}

package com.kisan.kisan_android.ui.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ContactPagerAdapter extends FragmentStatePagerAdapter {

    public ContactPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: ContactListFragment contactListFragment = new ContactListFragment();
                Log.e("Constant",contactListFragment.toString());
            return contactListFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

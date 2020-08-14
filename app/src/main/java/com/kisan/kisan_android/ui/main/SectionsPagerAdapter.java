package com.kisan.kisan_android.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kisan.kisan_android.MainActivity;
import com.kisan.kisan_android.R;
public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    Context mContext;
    HomeFragment homeFragment;
    Bundle bundle;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public SectionsPagerAdapter(FragmentManager fragmentManager, Bundle bundle, Context context, HomeFragment fragment) {
        super(fragmentManager);
        this.bundle = bundle;
        this.mContext = context;
        this.homeFragment = fragment;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: ContactListFragment contactListFragment = new ContactListFragment();
            contactListFragment.setArguments(bundle);
                return contactListFragment;
            case 1: MessageSentListFragment messageSentListFragment = new MessageSentListFragment();
                return messageSentListFragment;

        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}
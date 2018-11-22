package com.lonelydeveloper97.nanolaw.generic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Pair;

import java.util.List;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    private final FragmentPagerModel model;

    public FragmentPagerAdapter(FragmentManager fm, FragmentPagerModel model) {
        super(fm);
        this.model = model;
    }

    @Override
    public Fragment getItem(int position) {
        return model.nameFragmentPairs().get(position).second;
    }

    @Override
    public int getCount() {
        return model.nameFragmentPairs().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return model.nameFragmentPairs().get(position).first;
    }

    public interface FragmentPagerModel {
        List<Pair<String, Fragment>> nameFragmentPairs();

        int defaultPosition();
    }

}
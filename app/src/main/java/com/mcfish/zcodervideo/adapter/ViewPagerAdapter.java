package com.mcfish.zcodervideo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> fragments;
    private final List<String> pageTitles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> pageTitles) {
        super(fm);
        this.fragments = fragments;
        this.pageTitles = pageTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

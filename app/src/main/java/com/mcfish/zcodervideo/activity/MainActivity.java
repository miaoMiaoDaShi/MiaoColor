package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonActivity;
import com.mcfish.zcodervideo.fragment.HomeFragment;
import com.mcfish.zcodervideo.fragment.MineFragment;
import com.mcfish.zcodervideo.fragment.ResFragment;

import butterknife.BindView;

public class MainActivity extends BaseCommonActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private FragmentManager mFragmentManager;
    private Fragment mContent;
    private HomeFragment mHomeFragment;
    private ResFragment mResourcesFragment;
    private MineFragment mMineFragment;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpPages();
    }

    private void setUpPages() {
        navigation.setOnNavigationItemSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * 设置默认的显示页面 也就是HomeFragment
     */
    private void setDefaultFragment() {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mHomeFragment = new HomeFragment();
        transaction.add(R.id.flContent, mHomeFragment);
        transaction.commit();
        mContent = mHomeFragment;



    }

    /**
     * 界面的切换
     *
     * @param to
     */
    public void switchContent(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                // 隐藏当前的fragment，add下一个到Activity中
                transaction.hide(mContent).add(R.id.flContent, to).commit();
            } else {
                transaction.hide(mContent).show(to).commit(); // 隐藏当前的fragment，显示下一个
            }
            mContent = to;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigationHome:
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.newInstance();
                }
                switchContent(mHomeFragment);
                break;
            case R.id.navigationResources:
                if (mResourcesFragment == null) {
                    mResourcesFragment = ResFragment.newInstance();
                }
                switchContent(mResourcesFragment);
                break;
            case R.id.navigationMine:
                if (mMineFragment == null) {
                    mMineFragment = MineFragment.newInstance();
                }
                switchContent(mMineFragment);
                break;
            default:
        }
        return true;
    }
}

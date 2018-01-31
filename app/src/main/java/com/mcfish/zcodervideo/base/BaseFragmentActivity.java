package com.mcfish.zcodervideo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mcfish.zcodervideo.R;


/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/10/23
 * Description :
 */

public abstract class BaseFragmentActivity extends BaseCommonActivity {

    private Fragment mFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_content;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected void initView() {
        mFragment = this.getFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentTransaction.isEmpty()) {
            fragmentTransaction.add(R.id.flContent, mFragment);
        } else {
            fragmentTransaction.replace(R.id.flContent, mFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    protected abstract Fragment getFragment();

}

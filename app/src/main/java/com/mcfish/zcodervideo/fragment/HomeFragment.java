package com.mcfish.zcodervideo.fragment;

import android.support.v4.app.Fragment;

import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonFragment;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class HomeFragment extends BaseCommonFragment {
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}

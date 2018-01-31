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


public class MineFragment extends BaseCommonFragment {
    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}

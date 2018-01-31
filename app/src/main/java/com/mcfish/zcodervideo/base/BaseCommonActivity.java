package com.mcfish.zcodervideo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;


import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description : [普通的基类Activity
 */


public abstract class BaseCommonActivity extends AppCompatActivity {

    protected Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int layoutId = getLayoutId();
        if (layoutId!=-1) {
            setContentView(layoutId);
        }
        unbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}

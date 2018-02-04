package com.mcfish.zcodervideo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceFragment;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/24
 * Description :
 */


public abstract class BaseLceFragment<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceFragment<CV, M, V, P> {

    protected Unbinder unbind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        unbind = ButterKnife.bind(this, rootView);
        onCreateView(savedInstanceState);
        return rootView;
    }
    protected void onCreateView(Bundle savedInstanceState) {

    }
    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbind != null) {
            unbind.unbind();
        }
    }
}

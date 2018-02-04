package com.mcfish.zcodervideo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.mcfish.zcodervideo.R;

import butterknife.BindView;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/10/23
 * Description : RecyclerView可继承此类
 */


public abstract class BaseLceForRecyclerViewActivity<A extends RecyclerView.Adapter, CV extends View, M,
        V extends MvpLceView<M>,
        P extends MvpPresenter<V>> extends BaseLceActivity<CV, M, V, P> {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private A mAdapter;

    protected RecyclerView getRecyclerView() {
        return recyclerView;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = createAdapetr();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(getLayoutManager());

        if (contentView instanceof SwipeRefreshLayout) {
            ((SwipeRefreshLayout) contentView).setColorSchemeResources(
                    R.color.colorPrimary);
        }
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        showLoading(pullToRefresh);
    }

    protected final A getAdapter() {
        return mAdapter;
    }

    protected abstract A createAdapetr();

    protected abstract <T extends RecyclerView.LayoutManager> T getLayoutManager();




    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "没有网络,点击重试";
    }



}

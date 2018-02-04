package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.mcfish.code.utils.GlideUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.activity.VideoDetailActivity;
import com.mcfish.zcodervideo.base.BaseLceForRecyclerViewFragment;
import com.mcfish.zcodervideo.contract.ResChildVideosContract;
import com.mcfish.zcodervideo.model.bean.ResChildVideosInfo;
import com.mcfish.zcodervideo.presenter.ResChildVideosPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description : 分类详情下的列表数据
 */


public class ResChildVideosFragment extends
        BaseLceForRecyclerViewFragment<BaseQuickAdapter, SmartRefreshLayout, ResChildVideosInfo,
                ResChildVideosContract.View, ResChildVideosContract.Presenter>
        implements ResChildVideosContract.View, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemClickListener {

    private String mMcId;
    private int mPerpage;

    public static Fragment newInstance(String mcId) {
        Bundle bundle = new Bundle();
        bundle.putString("mcId", mcId);
        ResChildVideosFragment fragment = new ResChildVideosFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BaseQuickAdapter createAdapetr() {
        return new BaseQuickAdapter<ResChildVideosInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_video_type_a) {
            @Override
            protected void convert(BaseViewHolder helper, ResChildVideosInfo.DataBean.ListBean item) {
                helper.setText(R.id.tvTitle, item.getMv_title());
                GlideUtils.load(helper.itemView, item.getMv_img_url(), (ImageView) helper.getView(R.id.ivImage));
            }
        };
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPerpage = 10;
        mMcId = getArguments().getString("mcId");
        loadData(false);
        getAdapter().setOnLoadMoreListener(this, getRecyclerView());
        getAdapter().setOnItemClickListener(this);
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getContext(), 2);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        super.loadData(pullToRefresh);
        presenter.loadResChildVideos(mMcId, mPerpage, pullToRefresh);
    }

    @Override
    public void setData(ResChildVideosInfo data) {
        if (data.getData().getList().isEmpty()) {
            getAdapter().loadMoreEnd();
        }
        getAdapter().loadMoreComplete();
        getAdapter().addData(data.getData().getList());
    }

    @Override
    public ResChildVideosContract.Presenter createPresenter() {
        return new ResChildVideosPresenter();
    }

    @Override
    public void onLoadMoreRequested() {
        loadData(true);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final ResChildVideosInfo.DataBean.ListBean bean = (ResChildVideosInfo.DataBean.ListBean) adapter.getData().get(position);
        VideoDetailActivity.startAction(getActivity(), bean);
    }
}

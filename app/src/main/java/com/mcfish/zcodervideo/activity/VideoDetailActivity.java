package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcfish.code.utils.GlideUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseLceForRecyclerViewActivity;
import com.mcfish.zcodervideo.contract.ResChildVideosContract;
import com.mcfish.zcodervideo.listener.VideoListener;
import com.mcfish.zcodervideo.model.bean.ResChildVideosInfo;
import com.mcfish.zcodervideo.presenter.ResChildVideosPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/3
 * Description :
 */


public class VideoDetailActivity extends BaseLceForRecyclerViewActivity<BaseQuickAdapter,
        SmartRefreshLayout, ResChildVideosInfo,
        ResChildVideosContract.View, ResChildVideosContract.Presenter>
        implements ResChildVideosContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.mVideoView)
    StandardGSYVideoPlayer mVideoView;
    @BindView(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String mMcId;
    private int mPerpage;
    private String mUrl;
    private String mTitle;
    private OrientationUtils mOrientationUtils;
    private ResChildVideosInfo.DataBean.ListBean mBean;

    public static void startAction(Context context, ResChildVideosInfo.DataBean.ListBean bean) {
        Intent intent = new Intent(context, VideoDetailActivity.class);
        intent.putExtra("data", bean);
        context.startActivity(intent);

    }

    @Override
    public void onLoadMoreRequested() {
        loadData(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mPerpage = 10;
        mBean = getIntent().getParcelableExtra("data");
        mMcId = mBean.getMc_id();
        mUrl = mBean.getMv_play_url().replace("http://up.qqkin.com/","http://sb.qqkin.com/");
        mTitle = mBean.getMv_title();


        loadData(false);
        getAdapter().setOnLoadMoreListener(this, getRecyclerView());
        setUpPlayer();
    }

    private void setUpPlayer() {
        mOrientationUtils = new OrientationUtils(this, mVideoView);
        mVideoView.setRotateViewAuto(true);
        mVideoView.setIsTouchWiget(true);
        final ImageView thumbImageView = new ImageView(getApplicationContext());
        GlideUtils.load(this, mBean.getMv_img_url(), thumbImageView);
        mVideoView.setThumbImageView(thumbImageView);
        mVideoView.setStandardVideoAllCallBack(new VideoListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                mOrientationUtils.setEnable(true);
            }
        });
        mVideoView.setUp(mUrl, true, mTitle);
        mVideoView.startPlayLogic();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        super.loadData(pullToRefresh);
        presenter.loadResChildVideos(mMcId, mPerpage, pullToRefresh);
    }

    @Override
    protected BaseQuickAdapter createAdapetr() {
        return new BaseQuickAdapter<ResChildVideosInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_video_type_b) {
            @Override
            protected void convert(BaseViewHolder helper, ResChildVideosInfo.DataBean.ListBean item) {
                helper.setText(R.id.tvTitle, item.getMv_title());
            }
        };
    }

    @Override
    protected <T extends RecyclerView.LayoutManager> T getLayoutManager() {
        return (T) new LinearLayoutManager(getApplicationContext());
    }

    @NonNull
    @Override
    public ResChildVideosContract.Presenter createPresenter() {
        return new ResChildVideosPresenter();
    }

    @Override
    public void setData(ResChildVideosInfo data) {
        if (data.getData().getList().isEmpty()) {
            getAdapter().loadMoreEnd();
        }
        getAdapter().loadMoreComplete();
        getAdapter().addData(data.getData().getList());
    }
}

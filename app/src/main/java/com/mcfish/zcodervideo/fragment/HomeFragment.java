package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcfish.code.utils.GlideUtils;
import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseMvpFragment;
import com.mcfish.zcodervideo.contract.HomeContract;
import com.mcfish.zcodervideo.model.bean.BannerInfo;
import com.mcfish.zcodervideo.model.bean.HomeImageInfo;
import com.mcfish.zcodervideo.model.bean.HomeNavsInfo;
import com.mcfish.zcodervideo.presenter.HomePresenter;
import com.mcfish.zcodervideo.utils.GlideImageLoader;
import com.mcfish.zcodervideo.utils.ShareManager;
import com.youth.banner.Banner;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class HomeFragment extends BaseMvpFragment<HomeContract.View, HomeContract.Presenter> implements HomeContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    private static final String TAG = "HomeFragment";
    @BindView(R.id.rv)
    RecyclerView rvImages;
    RecyclerView rvNav;
    @BindView(R.id.swipeRefreshView)
    SwipeRefreshLayout swipeRefreshView;
    private BaseQuickAdapter mNavAdapter;
    private BaseQuickAdapter mImagesAdapter;
    private View mHeadView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }


    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        presenter.loadHomeData();
    }

    private void initView() {
        setUpHeadView();
        setUpImages();
    }

    private void setUpHeadView() {
        mHeadView = getLayoutInflater().inflate(R.layout.home_head_view, null);
        rvNav = mHeadView.findViewById(R.id.rvNav);
        setUpNav();
    }

    private void setUpImages() {
        // rvImages.setNestedScrollingEnabled(false);
        rvImages.setLayoutManager(new LinearLayoutManager(getContext()));
        mImagesAdapter = new BaseQuickAdapter<HomeImageInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_home_images) {

            @Override
            protected void convert(BaseViewHolder helper, HomeImageInfo.DataBean.ListBean item) {
                try {
                    helper.setText(R.id.tvTitle, item.getMc_title());
                    GlideUtils.load(helper.itemView, item.getMa_images().get(0), (ImageView) helper.getView(R.id.ivImgA));
                    GlideUtils.load(helper.itemView, item.getMa_images().get(1), (ImageView) helper.getView(R.id.ivImgB));
                    GlideUtils.load(helper.itemView, item.getMa_images().get(2), (ImageView) helper.getView(R.id.ivImgC));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mImagesAdapter.addHeaderView(mHeadView);
        mImagesAdapter.setEnableLoadMore(true);
        mImagesAdapter.setOnLoadMoreListener(this, rvImages);
        rvImages.setAdapter(mImagesAdapter);
    }

    private void setUpNav() {
        //rvNav.setNestedScrollingEnabled(false);
        final int navRes[] = new int[]{R.drawable.ic_home_nav_a, R.drawable.ic_home_nav_b,
                R.drawable.ic_home_nav_c, R.drawable.ic_home_nav_d, R.drawable.ic_home_nav_e};
        rvNav.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mNavAdapter = new BaseQuickAdapter<HomeNavsInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_home_navs) {
            @Override
            protected void convert(BaseViewHolder helper, HomeNavsInfo.DataBean.ListBean item) {
                GlideUtils.load(helper.itemView, navRes[helper.getLayoutPosition()], (ImageView) helper.getView(R.id.ivImage));
                helper.setText(R.id.tvTitle, item.getMc_tags());

            }
        };
        rvNav.setAdapter(mNavAdapter);
    }

    private void setupBanner(Banner banner) {
        final BannerInfo bannerInfo = ShareManager.getHomeBannerInfo();
        if (bannerInfo != null) {
            final List<String> urls = new ArrayList<>(bannerInfo.getData().size());
            for (BannerInfo.DataBean dataBean : bannerInfo.getData()) {
                urls.add(dataBean.getImage());
            }
            banner.setImages(urls);
            //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            //设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            banner.start();
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void showBanner(@NotNull BannerInfo bannerInfo) {

    }

    @Override
    public void showNavigation(@NotNull HomeNavsInfo navsInfo) {
        mNavAdapter.replaceData(navsInfo.getData().getList());
    }

    @Override
    public void showImages(@NotNull HomeImageInfo imageInfo) {
        mImagesAdapter.loadMoreComplete();
        mImagesAdapter.addData(imageInfo.getData().getList());
    }

    @Override
    public void showError(@NotNull String e) {
        ToastUtils.show(e);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onLoadMoreRequested() {
        presenter.loadMoreData();
    }
}

package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseMvpFragment;
import com.mcfish.zcodervideo.contract.CeContract;
import com.mcfish.zcodervideo.entity.BannerInfo;
import com.mcfish.zcodervideo.entity.HomeImageInfo;
import com.mcfish.zcodervideo.entity.HomeNavsInfo;
import com.mcfish.zcodervideo.presenter.CePresenter;
import com.mcfish.zcodervideo.utils.GlideImageLoader;
import com.mcfish.zcodervideo.utils.ShareManager;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class HomeFragment extends BaseMvpFragment<CeContract.View, CePresenter> implements CeContract.View {
    @BindView(R.id.rv)
    RecyclerView rvImages;
    @BindView(R.id.rvNav)
    RecyclerView rvNav;
    @BindView(R.id.search_bar)
    CardView searchBar;
    private BaseQuickAdapter mNavAdapter;
    private BaseQuickAdapter mImagesAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public CePresenter createPresenter() {
        return new CePresenter();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }


    private void initData() {
        presenter.getHomeNavInfo();
    }

    private void initView() {
        setUpNav();
        setUpImages();
    }

    private void setUpImages() {
        rvImages.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mImagesAdapter = new BaseQuickAdapter<HomeImageInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_home_navs) {

            @Override
            protected void convert(BaseViewHolder helper, HomeImageInfo.DataBean.ListBean item) {

            }
        };
        rvNav.setAdapter(mImagesAdapter);
    }

    private void setUpNav() {
        rvNav.setLayoutManager(new GridLayoutManager(getContext(), 5));
        mNavAdapter = new BaseQuickAdapter<HomeNavsInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_home_navs) {
            @Override
            protected void convert(BaseViewHolder helper, HomeNavsInfo.DataBean.ListBean item) {
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
    public void onSuccess(Object o) {
        if (o instanceof HomeNavsInfo) {
            mNavAdapter.replaceData(((HomeNavsInfo) o).getData().getList());
        }
    }

    @Override
    public void onError(String e) {
        ToastUtils.show(e);
    }
}

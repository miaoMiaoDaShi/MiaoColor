package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.adapter.ViewPagerAdapter;
import com.mcfish.zcodervideo.base.BaseMvpActivity;
import com.mcfish.zcodervideo.contract.ResChildCategoryContract;
import com.mcfish.zcodervideo.fragment.ResChildVideosFragment;
import com.mcfish.zcodervideo.model.bean.ResChildCategoryInfo;
import com.mcfish.zcodervideo.presenter.ResChildCategoryPresenter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/2/2
 * Description :
 */


public class ResChildCategoryActivity
        extends BaseMvpActivity<ResChildCategoryContract.View,
        ResChildCategoryContract.Presenter> implements ResChildCategoryContract.View {

    @BindView(R.id.mTvTitle)
    TextView mTvTitle;
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    private String parentId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_res_child_category;
    }

    public static void startAction(Context context, String title,String parentId) {
        Intent intent = new Intent(context, ResChildCategoryActivity.class);
        intent.putExtra("parentId", parentId);
        intent.putExtra("title",title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parentId = getIntent().getStringExtra("parentId");
        mTvTitle.setText(getIntent().getStringExtra("title"));
        presenter.loadResourcesChildCategory(parentId);
    }

    @NonNull
    @Override
    public ResChildCategoryContract.Presenter createPresenter() {
        return new ResChildCategoryPresenter();
    }

    @Override
    public void showResourcesChildCategory(@NotNull ResChildCategoryInfo resourcesChildCategoryInfo) {
        final List<Fragment> fragments = new ArrayList<>();
        final List<String> pageTitles = new ArrayList<>();
        for (ResChildCategoryInfo.DataBean.ListBean listBean : resourcesChildCategoryInfo.getData().getList()) {

            fragments.add(ResChildVideosFragment.newInstance(listBean.getMc_id()));
            pageTitles.add(listBean.getMc_name());
        }
        setUpTabPage(fragments, pageTitles);
    }

    private void setUpTabPage(List<Fragment> fragments, List<String> pageTitles) {
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments, pageTitles));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void showError(@NotNull String string) {
        ToastUtils.show(string);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }


}

package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.activity.ResChildCategoryActivity;
import com.mcfish.zcodervideo.base.BaseCommonFragment;
import com.mcfish.zcodervideo.base.BaseMvpFragment;
import com.mcfish.zcodervideo.contract.ResourcesContract;
import com.mcfish.zcodervideo.model.bean.ResourcesInfo;
import com.mcfish.zcodervideo.presenter.ResourcesPresenter;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class ResourcesFragment extends BaseMvpFragment<ResourcesContract.View, ResourcesContract.Presenter> implements ResourcesContract.View, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.rvResources)
    RecyclerView rvResources;
    private BaseQuickAdapter mAdapter;

    public static ResourcesFragment newInstance() {
        return new ResourcesFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpResourcesView();
        initData();
    }

    private void initData() {
        presenter.loadResources();
    }

    private void setUpResourcesView() {
        rvResources.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BaseQuickAdapter<ResourcesInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_resources) {
            @Override
            protected void convert(BaseViewHolder helper, ResourcesInfo.DataBean.ListBean item) {
                helper.setText(R.id.tvName, item.getMc_name());
                if (helper.getLayoutPosition() == getItemCount() - 1) {
                    final View cardView = helper.getView(R.id.cardView);
                    final LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) cardView.getLayoutParams();
                    final int margin = (int) getResources().getDimension(R.dimen.spacing_middle);
                    lp.bottomMargin = margin;
                    cardView.setLayoutParams(lp);
                }
            }
        };
        mAdapter.setOnItemClickListener(this);
        rvResources.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_resource;
    }


    @Override
    public ResourcesContract.Presenter createPresenter() {
        return new ResourcesPresenter();
    }

    @Override
    public void showResources(@NotNull ResourcesInfo resourcesInfo) {
        mAdapter.replaceData(resourcesInfo.getData().getList());
    }

    @Override
    public void showError(@NotNull String string) {
        ToastUtils.show("加载失败~");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        final ResourcesInfo.DataBean.ListBean bean = (ResourcesInfo.DataBean.ListBean) adapter.getData().get(position);
        ResChildCategoryActivity.startAction(getActivity(), bean.getMc_id());

    }
}

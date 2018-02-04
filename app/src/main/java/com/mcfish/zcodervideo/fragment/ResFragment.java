package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcfish.code.utils.GlideUtils;
import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.activity.ResChildCategoryActivity;
import com.mcfish.zcodervideo.base.BaseMvpFragment;
import com.mcfish.zcodervideo.contract.ResContract;
import com.mcfish.zcodervideo.model.bean.ResInfo;
import com.mcfish.zcodervideo.presenter.ResPresenter;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class ResFragment extends BaseMvpFragment<ResContract.View, ResContract.Presenter> implements ResContract.View, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.rvResources)
    RecyclerView rvResources;
    private BaseQuickAdapter mAdapter;

    public static ResFragment newInstance() {
        return new ResFragment();
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
        final int resImages[] = new int[]{R.drawable.bg_image_a, R.drawable.bg_image_b, R.drawable.bg_image_c,
                R.drawable.bg_image_d, R.drawable.bg_image_e, R.drawable.bg_image_f,
                R.drawable.bg_image_g, R.drawable.bg_image_h, R.drawable.bg_image_i};
        mAdapter = new BaseQuickAdapter<ResInfo.DataBean.ListBean, BaseViewHolder>(R.layout.item_resources) {
            @Override
            protected void convert(BaseViewHolder helper, ResInfo.DataBean.ListBean item) {
                helper.setText(R.id.tvName, item.getMc_name());
                GlideUtils.load(helper.itemView, resImages[helper.getLayoutPosition()], (ImageView) helper.getView(R.id.ivImg));
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
    public ResContract.Presenter createPresenter() {
        return new ResPresenter();
    }

    @Override
    public void showResources(@NotNull ResInfo resourcesInfo) {
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
        final ResInfo.DataBean.ListBean bean = (ResInfo.DataBean.ListBean) adapter.getData().get(position);
        ResChildCategoryActivity.startAction(getActivity(),bean.getMc_name(), bean.getMc_id());

    }
}

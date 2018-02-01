package com.mcfish.zcodervideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonFragment;
import com.mcfish.zcodervideo.entity.UserInfo;
import com.mcfish.zcodervideo.utils.ShareManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class MineFragment extends BaseCommonFragment {
    @BindView(R.id.tvNickName)
    TextView tvNickName;

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }

    private void initView() {
        UserInfo info = ShareManager.getUserInfo();
        tvNickName.setText(info.getData().getMu_name());
    }


}

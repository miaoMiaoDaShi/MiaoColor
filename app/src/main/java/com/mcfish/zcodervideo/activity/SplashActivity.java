package com.mcfish.zcodervideo.activity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonActivity;
import com.mcfish.zcodervideo.model.bean.UserInfo;
import com.mcfish.zcodervideo.utils.ShareManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class SplashActivity extends BaseCommonActivity {
    @BindView(R.id.splashImg)
    ImageView splashImg;
    @BindView(R.id.btnSkin)
    Button btnSkin;
    @BindView(R.id.tvBug)
    TextView tvBug;
    @BindView(R.id.relativelayout_welcome)
    RelativeLayout relativelayoutWelcome;
    private ViewPropertyAnimator mViewPropertyAnimator;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, SplashActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPropertyAnimator = splashImg
                .animate()
                .alpha(1)
                .setDuration(2_000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        final UserInfo userInfo = ShareManager.getUserInfo();
                        if (userInfo != null) {
                            MainActivity.startAction(SplashActivity.this);
                        } else {
                            LoginActivity.startAction(SplashActivity.this);
                        }

                        finish();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    @OnClick(R.id.btnSkin)
    public void onViewClicked() {
        mViewPropertyAnimator.cancel();
    }
}

package com.mcfish.zcodervideo.activity;

import android.Manifest;
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonActivity;
import com.mcfish.zcodervideo.model.bean.UserInfo;
import com.mcfish.zcodervideo.utils.ShareManager;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.observers.DisposableObserver;


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
                        final RxPermissions rxPermissions = new RxPermissions(SplashActivity.this);
                        rxPermissions
                                .request(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_PHONE_STATE})
                                .subscribeWith(new DisposableObserver<Boolean>() {
                                    @Override
                                    public void onNext(Boolean aBoolean) {
                                        final UserInfo userInfo = ShareManager.getUserInfo();
                                        if (userInfo != null) {
                                            MainActivity.startAction(SplashActivity.this);
                                        } else {
                                            LoginActivity.startAction(SplashActivity.this);
                                        }

                                        finish();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        ToastUtils.showLong("不授权软件无法正常使用");
                                        finish();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });

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

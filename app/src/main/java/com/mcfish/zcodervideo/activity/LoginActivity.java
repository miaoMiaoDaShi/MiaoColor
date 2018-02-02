package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseMvpActivity;
import com.mcfish.zcodervideo.contract.LoginContract;
import com.mcfish.zcodervideo.model.bean.UserInfo;
import com.mcfish.zcodervideo.presenter.LoginPresenter;
import com.mcfish.zcodervideo.utils.ShareManager;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.OnClick;

import static com.mcfish.zcodervideo.ExtensionsKt.showToast;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :登录页面
 */


public class LoginActivity extends BaseMvpActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.txtAccount)
    EditText txtAccount;
    @BindView(R.id.txtPwd)
    EditText txtPwd;

    public static void startAction(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.tvForgetPwd, R.id.btnLogin, R.id.btnRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvForgetPwd:
                break;
            case R.id.btnLogin:
                final String account = txtAccount.getText().toString().trim();
                final String pwd = txtPwd.getText().toString();
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(pwd)) {
                    ToastUtils.showLong("任何一项不能为空~");
                    return;
                }
                presenter.login(account, pwd);
                break;
            case R.id.btnRegister:

                break;
            default:
        }
    }


    @Override
    public void showLoginSuccess(@NotNull UserInfo userInfo) {
        ToastUtils.show("登录成功~");
        ShareManager.saveUserInfo(userInfo);
        finish();
        MainActivity.startAction(this);
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

    @NonNull
    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }
}

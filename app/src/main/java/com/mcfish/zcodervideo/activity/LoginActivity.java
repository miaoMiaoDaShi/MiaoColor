package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mcfish.code.utils.ToastUtils;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseCommonActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :登录页面
 */


public class LoginActivity extends BaseCommonActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                break;
            case R.id.btnRegister:
                break;
            default:
        }
    }
}

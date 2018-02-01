package com.mcfish.zcodervideo.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mcfish.code.utils.ToastUtils;
import com.mcfish.code.Constant;
import com.mcfish.zcodervideo.R;
import com.mcfish.zcodervideo.base.BaseMvpActivity;
import com.mcfish.zcodervideo.contract.CeContract;
import com.mcfish.code.http.BaseRequest;
import com.mcfish.zcodervideo.entity.UserInfo;
import com.mcfish.zcodervideo.presenter.CePresenter;
import com.mcfish.code.utils.EncodeUtils;
import com.mcfish.code.utils.EncryptUtils;
import com.mcfish.zcodervideo.utils.ShareManager;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :登录页面
 */


public class LoginActivity extends BaseMvpActivity<CeContract.View, CePresenter> implements CeContract.View<UserInfo> {
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

    @Override
    public CePresenter createPresenter() {
        return new CePresenter();
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

//    /**
//     * 对象转化为map
//     *
//     * @param data
//     * @return
//     */
//    public static Map<String, String> parseData(Object data) {
//        Gson gson = new Gson();
//        String json = gson.toJson(data);
//        Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, String>>() {
//        }.getType());
//        return map;
//    }
//
//    public void getParams() {
//        final BaseRequest request = new BaseRequest();
//        Map<String, String> params = parseData(request);
//        if (params == null) {
//            params = new TreeMap();
//        }
//        StringBuilder sb = new StringBuilder("");
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            sb.append("&")
//                    .append(entry.getKey())
//                    .append("=")
//                    .append(EncodeUtils.urlEncode(entry.getValue(), "UTF-8"));
//        }
//        Log.i(TAG, "getParams: " +sb.toString());
//        request.setSig(EncryptUtils.encryptMD5ToString(sb.toString().substring(1) + Constant.URL_SIG_KEY));
//        Log.i(TAG, "getParams: " + request.toString());
//    }

    @Override
    public void onSuccess(UserInfo userInfo) {
        ToastUtils.show("登录成功~");
        ShareManager.saveUserInfo(userInfo);
        finish();
        MainActivity.startAction(this);
    }

    @Override
    public void onError(String e) {
        ToastUtils.show(e);
    }
}

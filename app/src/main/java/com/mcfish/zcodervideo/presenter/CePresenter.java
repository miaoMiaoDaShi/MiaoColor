package com.mcfish.zcodervideo.presenter;

import com.mcfish.code.http.BaseDisposable;
import com.mcfish.code.http.BaseResponse;
import com.mcfish.code.http.ExceptionHandle;
import com.mcfish.zcodervideo.contract.CeContract;
import com.mcfish.zcodervideo.entity.HomeNavsInfo;
import com.mcfish.zcodervideo.entity.IndexRequest;
import com.mcfish.zcodervideo.entity.LoginRequest;
import com.mcfish.zcodervideo.entity.UserInfo;
import com.mcfish.zcodervideo.model.CeService;
import com.mcfish.zcodervideo.utils.ShareManager;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/31
 * Description :
 */


public class CePresenter extends CeContract.Presenter {
    private UserInfo userInfo;

    public CePresenter() {
        userInfo = ShareManager.getUserInfo();
    }

    /**
     * 登录
     *
     * @param account
     * @param pwd
     */
    public void login(String account, String pwd) {
        final LoginRequest request = new LoginRequest();
        request.setEmail(account);
        request.setPassword(pwd);
        enqueue(new BaseDisposable<UserInfo>(getApi(CeService.class)
                .login(parseData(compositeRequest(request)))) {
            @Override
            public void onNext(UserInfo userInfo) {
                getView().onSuccess(userInfo);
            }

            @Override
            public void onError(ExceptionHandle.ResponseThrowable e) {
                getView().onError(e.message);
            }

        });

    }

    /**
     * 获取首页的导航
     */
    public void getHomeNavInfo() {
        enqueue(new BaseDisposable<HomeNavsInfo>(getApi(CeService.class)
                .getHomeNavInfo(parseData(compositeRequest(new IndexRequest(userInfo.getData().getMu_id()))))) {
            @Override
            public void onNext(HomeNavsInfo homeNavsInfo) {
                getView().onSuccess(homeNavsInfo);

            }

            @Override
            public void onError(ExceptionHandle.ResponseThrowable e) {
                getView().onError(e.message);
            }
        });
    }


}

package com.mcfish.code.http.intercept;

import android.text.TextUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2017/11/6
 * Description :
 */


public abstract class TokenHelperInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {


        Request originalRequest = chain.request();

        //判断主要是防止你在编写请求已经加入token 和uid
        final String token = TextUtils.isEmpty(originalRequest.header("token"))
                ? getToken() : originalRequest.header("token");
        final String uid = TextUtils.isEmpty(originalRequest.header("uid"))
                ? getUid() : originalRequest.header("uid");

        Request updateRequest = null;
        if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(uid)) {
            updateRequest = originalRequest.newBuilder()
                    .header("token", token)
                    .header("uid", uid)
                    .build();
        }

        final Response response = chain.proceed(null == updateRequest ? originalRequest : updateRequest);
        final ResponseBody responseBody = response.body();
        BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = responseBody.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        final String contentString = buffer.clone().readString(charset);
        Response newResponse = null;
        try {
            newResponse = onIntercept(chain, contentString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (newResponse != null) {
            return newResponse;
        }
        return response;
    }

    /**
     * 在这里面检测token是否可用  然后自行刷新token
     *
     * @param chain
     * @param string
     * @return
     */
    protected abstract Response onIntercept(Chain chain, String string);

    protected abstract String getUid();

    protected abstract String getToken();

}

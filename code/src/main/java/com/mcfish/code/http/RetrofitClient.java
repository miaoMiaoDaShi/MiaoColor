package com.mcfish.code.http;

import android.text.TextUtils;

import com.mcfish.code.Configurator;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/8
 * Description :
 */


public final class RetrofitClient {
    private final static long DEFAULT_TIMEOUT = 30;
    private final static OkHttpClient.Builder HTTP_CLIENT_BUILDER =
            new OkHttpClient.Builder()
                    .addInterceptor(
                            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    private final static CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

    /**
     * 默认使用此处的OkhttpCLient
     */
    public final static Retrofit.Builder RETROFIT_BUILDER =
            new Retrofit.Builder()
                    .client(Configurator.getInstance().getOkHttpClient() != null ? Configurator.getInstance().getOkHttpClient()
                            : HTTP_CLIENT_BUILDER.build())
                    .addConverterFactory(AesGsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Configurator.getInstance().getApiHost());

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RetrofitClient() {
    }


    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static <T> T getApiService(final Class<T> service) {
        return RETROFIT_BUILDER.build().create(service);
    }


    private static ObservableTransformer transformer() {

        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {

                return upstream.map(new HandleFun()).onErrorResumeNext(new TransformToCustomException());
            }
        };
    }

    /**
     * 这里是关键
     *
     * @param disposable
     * @param <E>        你必须继承我的BaseDisposable
     * @param <T>        数据类型
     * @return
     * @see BaseDisposable
     */
    public <E extends BaseDisposable<T>, T extends BaseResponse> E subscribe(BaseDisposable<T> disposable) {

        COMPOSITE_DISPOSABLE.add(disposable);
        disposable
                .getObservable()
                .compose(schedulersTransformer())
                .compose(transformer())
                .subscribeWith(disposable);

        return (E) disposable;
    }


    /**
     * 线程的调度
     *
     * @return
     */
    private final static ObservableTransformer schedulersTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 抛出的异常转化成 自定义的异常
     */
    private static class TransformToCustomException implements Function<Throwable, Observable> {

        @Override
        public Observable apply(Throwable throwable) throws Exception {
            return Observable.error(ExceptionHandle.handleException(throwable));
        }
    }

    /**
     * 检测返回的数据是不是Ok的
     */
    private static class HandleFun implements Function {
        @Override
        public Object apply(Object o) throws Exception {
            BaseResponse response = (BaseResponse) o;
            if (!response.isOk()) {
                //如果错误码和错误信息都是null,
                throw new RuntimeException(TextUtils.isEmpty(response.getCode() + "" + response.getMessage())
                        ? "" : response.getMessage());
            }
            return o;
        }
    }


}

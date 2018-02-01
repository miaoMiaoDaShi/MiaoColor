package com.mcfish.code.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.mcfish.code.Constant;
import com.mcfish.code.utils.AesEncryptionUtil;
import com.mcfish.code.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Converter;

final class AesGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String TAG = "AesGsonResponseBodyConv";
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    AesGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource source = value.source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        Charset charset = UTF8;
        MediaType contentType = value.contentType();
        if (contentType != null) {
            charset = contentType.charset(UTF8);
        }
        final String contentString = buffer.clone().readString(charset);
        final String newString = AesEncryptionUtil.
                decrypt(contentString, Constant.AES_PWD, Constant.AES_IV);
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(newString);
            if (jsonObject.getInt("code") != 0) {
                jsonObject.put("data", null);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final InputStream inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes());
        Log.i(TAG, "convert: " + inputStream.toString());
        JsonReader jsonReader = gson.newJsonReader(new InputStreamReader(inputStream, UTF8));
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
package com.mcfish.code.utils;

import android.os.Build;
import android.text.Html;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodeUtils {
    private EncodeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String urlEncode(String input) {
        return urlEncode(input, "UTF-8");
    }

    public static String urlEncode(String input, String charset) {
        try {
            input = URLEncoder.encode(input, charset);
        } catch (UnsupportedEncodingException e) {
        }
        return input;
    }

    public static String urlDecode(String input) {
        return urlDecode(input, "UTF-8");
    }

    public static String urlDecode(String input, String charset) {
        try {
            input = URLDecoder.decode(input, charset);
        } catch (UnsupportedEncodingException e) {
        }
        return input;
    }

    public static byte[] base64Encode(String input) {
        return base64Encode(input.getBytes());
    }

    public static byte[] base64Encode(byte[] input) {
        return Base64.encode(input, 2);
    }

    public static String base64Encode2String(byte[] input) {
        return Base64.encodeToString(input, 2);
    }

    public static byte[] base64Decode(String input) {
        return Base64.decode(input, 2);
    }

    public static byte[] base64Decode(byte[] input) {
        return Base64.decode(input, 2);
    }

    public static byte[] base64UrlSafeEncode(String input) {
        return Base64.encode(input.getBytes(), 8);
    }


}
package com.mcfish.zcodervideo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.mcfish.code.utils.GlideUtils;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        GlideUtils.load(context, path,imageView);

    }
}
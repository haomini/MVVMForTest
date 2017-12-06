package com.example.common.databind.adapters;

import android.databinding.BindingAdapter;
import android.databinding.adapters.ImageViewBindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @Describe
 * @Author zhouhao
 * @Date 2017/12/1
 * @Contact 605626708@qq.com
 */

public class ImageViewBinding extends ImageViewBindingAdapter {

    @BindingAdapter({"url", "error"})
    public static void loadImage(ImageView img, String url, Drawable error) {
        Glide.with(img.getContext())
                .load(url)
                .apply(new RequestOptions()
                        .error(error)
                        .centerCrop())
                .into(img);

    }
}

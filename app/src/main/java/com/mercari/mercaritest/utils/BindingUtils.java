package com.mercari.mercaritest.utils;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public final class BindingUtils {

    private BindingUtils() {
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with((Activity)imageView.getContext()).load(url).into(imageView);
    }
}

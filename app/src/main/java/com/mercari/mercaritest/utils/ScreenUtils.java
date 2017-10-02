package com.mercari.mercaritest.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public final class ScreenUtils {

    private ScreenUtils() {
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

}

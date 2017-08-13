package com.akturk.cv.util;


import android.content.res.Resources;

public final class DimensionUtils {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources
                .getSystem()
                .getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources
                .getSystem()
                .getDisplayMetrics().density);
    }
}

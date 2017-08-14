package com.akturk.cv.util;

import android.content.Context;
import android.telephony.TelephonyManager;

public final class DeviceUtils {

    public static boolean isTablet(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return (manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE);
    }
}
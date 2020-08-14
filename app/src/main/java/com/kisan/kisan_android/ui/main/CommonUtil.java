package com.kisan.kisan_android.ui.main;

import android.util.Patterns;

public class CommonUtil {

    public static boolean isValidString(String s) {
        return (s != null && !s.trim().isEmpty() && !s.equalsIgnoreCase("null"));
    }

    public static boolean isValidMobile(String string) {
        return (isValidString(string) && string.length() == 10 && Patterns.PHONE.matcher(string).matches() && ((string.startsWith("6") || string.startsWith("7") || string.startsWith("8") || string.startsWith("9"))));
    }
}

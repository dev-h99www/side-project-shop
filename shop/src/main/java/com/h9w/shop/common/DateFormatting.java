package com.h9w.shop.common;

import java.text.SimpleDateFormat;

public class DateFormatting {

    public static String getDate() {

        return new SimpleDateFormat("yyyy-MM-dd").format(new java.sql.Date(System.currentTimeMillis()));
    }
    public static String getDateAndTime() {

        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.sql.Date(System.currentTimeMillis()));
    }
}

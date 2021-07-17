package com.example.springboottest.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
    /**
     * This Function Returns the Current DateTime of the System
     *
     * @return
     */
    public static Timestamp getCurrentDateTime() {
        try {
            SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

            String aDate = aSimpleDateFormat.format(new Date(Calendar.getInstance().getTimeInMillis()));

            return Timestamp.valueOf(aDate);
        } catch (Exception e) {
            return new Timestamp(Calendar.getInstance().getTimeInMillis());
        }
    }
}

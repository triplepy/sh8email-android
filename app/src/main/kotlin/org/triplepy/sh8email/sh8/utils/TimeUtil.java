package org.triplepy.sh8email.sh8.utils;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.app.App;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeUtil {
    private static final int SEC = 60;
    private static final int MIN = 60;
    private static final int HOUR = 24;
    private static final int DAY = 30;
    private static final int MONTH = 12;

    public static String formatTimeString(String tempDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'", Locale.getDefault());
            format.setTimeZone(TimeZone.getTimeZone("UTC"));
            Date date = format.parse(tempDate);

            long curTime = System.currentTimeMillis();
            long regTime = date.getTime();
            long diffTime = (curTime - regTime) / 1000;

            String msg;
            if (diffTime < SEC) {
                msg = App.context.getString(R.string.time_now);
            } else if ((diffTime /= SEC) < MIN) {
                msg = diffTime + App.context.getString(R.string.time_minute_ago);
            } else if ((diffTime /= MIN) < HOUR) {
                msg = (diffTime) + App.context.getString(R.string.time_hour_ago);
            } else if ((diffTime /= HOUR) < DAY) {
                msg = (diffTime) + App.context.getString(R.string.time_day_ago);
            } else if ((diffTime /= DAY) < MONTH) {
                msg = (diffTime) + App.context.getString(R.string.time_month_ago);
            } else {
                msg = (diffTime) + App.context.getString(R.string.time_year_ago);
            }
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return App.context.getString(R.string.time_some_ago);
    }
}
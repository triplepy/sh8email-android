package org.triplepy.sh8email.sh8.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    private static final int SEC = 60;
    private static final int MIN = 60;
    private static final int HOUR = 24;
    private static final int DAY = 30;
    private static final int MONTH = 12;

    public static String formatTimeString(String tempDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSS'Z'", Locale.KOREAN);
            Date date = format.parse(tempDate);

            long curTime = System.currentTimeMillis();
            long regTime = date.getTime();
            long diffTime = (curTime - regTime) / 1000;

            String msg;
            if (diffTime < SEC) {
                msg = "방금 전";
            } else if ((diffTime /= SEC) < MIN) {
                msg = diffTime + "분 전";
            } else if ((diffTime /= MIN) < HOUR) {
                msg = (diffTime) + "시간 전";
            } else if ((diffTime /= HOUR) < DAY) {
                msg = (diffTime) + "일 전";
            } else if ((diffTime /= DAY) < MONTH) {
                msg = (diffTime) + "달 전";
            } else {
                msg = (diffTime) + "년 전";
            }
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "언젠가";
    }
}
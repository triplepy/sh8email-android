package org.triplepy.sh8email.sh8.utils;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.LoginEvent;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.utils
 * ==============================
 * Created by igangsan on 2016. 9. 1..
 */

public class LogAppEventUtil {
    public static void eventLogin(String method, Boolean isLoginSucceeded, Integer responseCode) {
        Answers.getInstance().logLogin(new LoginEvent()
                .putMethod(method)
                .putSuccess(isLoginSucceeded)
                .putCustomAttribute("responseCode", responseCode)
        );
    }
}
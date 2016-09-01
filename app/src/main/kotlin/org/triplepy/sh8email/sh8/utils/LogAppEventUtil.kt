package org.triplepy.sh8email.sh8.utils

import com.crashlytics.android.answers.Answers
import com.crashlytics.android.answers.LoginEvent

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.utils
 * ==============================
 * Created by igangsan on 2016. 9. 1..
 */

object LogAppEventUtil {
    fun eventLogin(method: String, isLoginSucceeded: Boolean, responseCode: Int = 200) {
        Answers.getInstance().logLogin(LoginEvent()
                .putMethod(method)
                .putSuccess(isLoginSucceeded)
                .putCustomAttribute("responseCode", responseCode)
        )
    }
}
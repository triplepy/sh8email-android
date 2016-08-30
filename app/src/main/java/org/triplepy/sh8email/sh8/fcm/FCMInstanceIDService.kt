package org.triplepy.sh8email.sh8.fcm

import android.util.Log

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.fcm
 * ==============================
 * Created by igangsan on 2016. 8. 30..
 */

class FCMInstanceIDService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d("FCMInstanceService", "Refreshed token: " + refreshedToken)

        // TODO : 토큰 값 등록
    }
}

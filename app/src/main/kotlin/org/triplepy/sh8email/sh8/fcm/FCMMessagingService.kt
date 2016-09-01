package org.triplepy.sh8email.sh8.fcm

import android.util.Log
import com.crashlytics.android.Crashlytics

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

import org.triplepy.sh8email.sh8.utils.NotificationUtil

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.fcm
 * ==============================
 * Created by igangsan on 2016. 8. 30..
 */

class FCMMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        Log.d("FCMService", "Message Delivered!")
        Crashlytics.log(Log.ERROR, "FCMService >> ","Message Delivered!");
        val notification = remoteMessage?.notification
        NotificationUtil.sendNotification(this, notification?.title, notification?.body)
    }
}

package org.triplepy.sh8email.sh8.fcm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.triplepy.sh8email.sh8.utils.NotificationUtil;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.fcm
 * ==============================
 * Created by igangsan on 2016. 8. 30..
 */

public class FCMMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("FCMService", "Message Delivered!");
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        NotificationUtil.sendNotification(this, notification.getTitle(), notification.getBody());
    }
}

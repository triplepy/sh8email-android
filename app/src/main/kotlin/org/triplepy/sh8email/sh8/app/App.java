package org.triplepy.sh8email.sh8.app;


import android.app.Application;

import com.crashlytics.android.Crashlytics;

import org.triplepy.sh8email.sh8.SharedPreferencesController;

import io.fabric.sdk.android.Fabric;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.app
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 * <p>
 * Application 클래스
 * 현재 Crashlytics만 추가하였습니다.
 *
 * @author 이강산 (river-mountain)
 */

public class App extends Application {
    public static SharedPreferencesController pref;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        pref = new SharedPreferencesController(this, "sh8Pref");
    }
}

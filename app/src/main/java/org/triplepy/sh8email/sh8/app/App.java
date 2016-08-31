package org.triplepy.sh8email.sh8.app;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import org.triplepy.sh8email.sh8.di.component.ClientComponent;
import org.triplepy.sh8email.sh8.di.component.DaggerClientComponent;
import org.triplepy.sh8email.sh8.di.module.ClientModule;

import io.fabric.sdk.android.Fabric;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.app
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

public class App extends Application {
    private ClientComponent clientComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        clientComponent = DaggerClientComponent.builder()
                .clientModule(new ClientModule())
                .build();
    }

    public ClientComponent getClientComponent() {
        return clientComponent;
    }
}

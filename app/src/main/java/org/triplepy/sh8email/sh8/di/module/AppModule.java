package org.triplepy.sh8email.sh8.di.module;

import org.triplepy.sh8email.sh8.app.App;

import dagger.Module;
import dagger.Provides;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.module
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public App provideApp() {
        return app;
    }
}
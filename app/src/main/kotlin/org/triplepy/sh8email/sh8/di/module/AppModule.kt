package org.triplepy.sh8email.sh8.di.module

import dagger.Module
import dagger.Provides
import org.triplepy.sh8email.sh8.app.App

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.module
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */
@Module
class AppModule(val app: App) {

    @Provides
    fun provideApp(): App {
        return app
    }
}
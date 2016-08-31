package org.triplepy.sh8email.sh8.app

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import org.triplepy.sh8email.sh8.di.component.ClientComponent
import org.triplepy.sh8email.sh8.di.component.DaggerClientComponent
import org.triplepy.sh8email.sh8.di.module.ClientModule

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.app
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

class App : Application() {
    lateinit var clientComponent: ClientComponent

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())

        clientComponent = DaggerClientComponent.builder().clientModule(ClientModule()).build()
    }
}

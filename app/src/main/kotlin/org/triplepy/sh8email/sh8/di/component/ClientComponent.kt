package org.triplepy.sh8email.sh8.di.component

import dagger.Component
import org.triplepy.sh8email.sh8.activities.MainActivity
import org.triplepy.sh8email.sh8.di.module.ClientModule
import javax.inject.Singleton

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.component
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

@Singleton
@Component(modules = arrayOf(ClientModule::class))
interface ClientComponent {
    fun inject(activity: MainActivity)
}

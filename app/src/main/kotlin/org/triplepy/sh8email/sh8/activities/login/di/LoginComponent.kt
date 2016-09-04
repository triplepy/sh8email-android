package org.triplepy.sh8email.sh8.activities.login.di

import dagger.Component
import org.triplepy.sh8email.sh8.activities.login.LoginActivity

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login.di
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */
@Component(modules = arrayOf(LoginModule::class))
interface LoginComponent {
    fun inject(activity: LoginActivity)
}
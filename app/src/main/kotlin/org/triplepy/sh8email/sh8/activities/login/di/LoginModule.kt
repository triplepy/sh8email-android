package org.triplepy.sh8email.sh8.activities.login.di

import dagger.Module
import dagger.Provides
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenterImpl
import org.triplepy.sh8email.sh8.di.module.ClientModule

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login.di
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */
@Module(includes = arrayOf(ClientModule::class))
class LoginModule {
    val view: LoginPresenter.View

    constructor(view: LoginPresenter.View) {
        this.view = view
    }

    @Provides
    fun provideLoginPresenter(loginPresenter: LoginPresenterImpl): LoginPresenter {
        return loginPresenter
    }

    @Provides
    fun provideLoginView(): LoginPresenter.View {
        return view
    }
}
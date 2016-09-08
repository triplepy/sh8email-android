package org.triplepy.sh8email.sh8.activities.login.di;


import org.triplepy.sh8email.sh8.activities.login.LoginActivity;

import dagger.Component;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login.di
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */
@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
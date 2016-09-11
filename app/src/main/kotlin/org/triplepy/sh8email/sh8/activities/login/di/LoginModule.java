package org.triplepy.sh8email.sh8.activities.login.di;


/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login.di
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */

import org.triplepy.sh8email.sh8.api.ClientModule;
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

@Module(includes = ClientModule.class)
public class LoginModule {
    private LoginPresenter.View view;

    public LoginModule(LoginPresenter.View view){
        this.view = view;
    }

    @Provides
    public LoginPresenter.View provideLoginView(){
        return view;
    }
}
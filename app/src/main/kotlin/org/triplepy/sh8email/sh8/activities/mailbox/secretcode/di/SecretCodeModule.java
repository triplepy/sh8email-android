package org.triplepy.sh8email.sh8.activities.mailbox.secretcode.di;

import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.presenter.SecretCodePresenter;
import org.triplepy.sh8email.sh8.api.ClientModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jelly on 1/2/17.
 */

@Module(includes = ClientModule.class)
public class SecretCodeModule {
    private SecretCodePresenter.View view;

    public SecretCodeModule(SecretCodePresenter.View view) {
        this.view = view;
    }

    @Provides
    public SecretCodePresenter.View provideSecretCodeView() {
        return view;
    }
}

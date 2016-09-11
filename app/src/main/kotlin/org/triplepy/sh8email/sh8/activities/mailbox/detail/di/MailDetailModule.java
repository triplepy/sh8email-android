package org.triplepy.sh8email.sh8.activities.mailbox.detail.di;

import org.triplepy.sh8email.sh8.api.ClientModule;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter.MailDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.detail.di
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

@Module(includes = ClientModule.class)
public class MailDetailModule {
    private MailDetailPresenter.View view;

    public MailDetailModule(MailDetailPresenter.View view) {
        this.view = view;
    }

    @Provides
    public MailDetailPresenter.View provideMailDetailView() {
        return view;
    }
}

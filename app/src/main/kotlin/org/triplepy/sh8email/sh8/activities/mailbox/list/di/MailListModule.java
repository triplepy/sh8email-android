package org.triplepy.sh8email.sh8.activities.mailbox.list.di;

import org.triplepy.sh8email.sh8.activities.mailbox.list.presenter.MailListPresenter;
import org.triplepy.sh8email.sh8.api.ClientModule;

import dagger.Module;
import dagger.Provides;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.list.di
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

@Module(includes = ClientModule.class)
public class MailListModule {
    private MailListPresenter.View view;

    public MailListModule(MailListPresenter.View view) {
        this.view = view;
    }

    @Provides
    public MailListPresenter.View provideMailListView() {
        return view;
    }
}

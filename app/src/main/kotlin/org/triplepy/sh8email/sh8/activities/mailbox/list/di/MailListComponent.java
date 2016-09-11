package org.triplepy.sh8email.sh8.activities.mailbox.list.di;

import org.triplepy.sh8email.sh8.activities.mailbox.list.MailListActivity;

import dagger.Component;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.list.di
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

@Component(modules = MailListModule.class)
public interface MailListComponent {
    void inject(MailListActivity activity);
}

package org.triplepy.sh8email.sh8.activities.mailbox.detail.di;

import org.triplepy.sh8email.sh8.activities.mailbox.detail.MailDetailActivity;

import dagger.Component;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.detail.di
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

@Component(modules = MailDetailModule.class)
public interface MailDetailComponent {
    void inject(MailDetailActivity activity);
}

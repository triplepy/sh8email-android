package org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter;

import org.triplepy.sh8email.sh8.data.Mail;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

public interface MailDetailPresenter {
    void getMail(String nickname, Long pk);
    interface View {
        void setupMail(Mail mail);
    }
}

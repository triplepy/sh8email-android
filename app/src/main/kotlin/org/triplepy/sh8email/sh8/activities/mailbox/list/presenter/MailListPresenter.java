package org.triplepy.sh8email.sh8.activities.mailbox.list.presenter;

import org.triplepy.sh8email.sh8.data.Mail;

import java.util.ArrayList;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.list.presenter
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

public interface MailListPresenter {
    void getMailBoxWithId(String id);

    interface View {
        void setupMailBox(ArrayList<Mail> mails);
    }
}

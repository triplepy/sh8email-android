package org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter;

import org.triplepy.sh8email.sh8.api.Sh8Client;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

public class MailDetailPresenterImpl implements MailDetailPresenter{
    private View view;
    private Sh8Client client;

    @Inject
    public MailDetailPresenterImpl(View view, Sh8Client client){
        this.view = view;
        this.client = client;
    }

    @Override
    public void getMail(String nickname, Long pk, String secretCode) {
        client.getMailDetail(nickname, pk, secretCode)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mail -> {
                    view.setupMail(mail);
                });
    }
}

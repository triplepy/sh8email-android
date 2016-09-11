package org.triplepy.sh8email.sh8.activities.mailbox.list.presenter;

import org.triplepy.sh8email.sh8.api.Sh8Client;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.mailbox.list.presenter
 * ==============================
 * Created by igangsan on 2016. 9. 11..
 */

public class MailListPresenterImpl implements MailListPresenter {
    private View view;
    private Sh8Client client;

    @Inject
    public MailListPresenterImpl(View view, Sh8Client client) {
        this.view = view;
        this.client = client;
    }

    @Override
    public void getMailBoxWithId(String id) {
        client.getMailBox(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(it -> {
                   view.setupMailBox(it);
                });
    }
}

package org.triplepy.sh8email.sh8.activities.mailbox.secretcode.presenter;

import org.triplepy.sh8email.sh8.api.Sh8Client;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jelly on 1/2/17.
 */
public class SecretCodePresenterImpl implements SecretCodePresenter {
    private View view;

    private Sh8Client client;

    @Inject
    public SecretCodePresenterImpl(View view, Sh8Client client) {
        this.view = view;
        this.client = client;
    }
}

package org.triplepy.sh8email.sh8.activities;

import android.os.Bundle;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.api.Sh8Client;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends BaseActivity {
    @Inject
    Sh8Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getClientComponent().inject(this);

        client.loginWithEmail("test@naver.com")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                    // TODO : ResponseBody..
                }, Throwable::printStackTrace);
    }
}

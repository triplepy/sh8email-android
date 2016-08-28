package org.triplepy.sh8email.sh8.api;


import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.api.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */
@Singleton
public class Sh8Client {
    private LoginService loginService;

    @Inject
    public Sh8Client(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        loginService = retrofit.create(LoginService.class);
    }

    public Observable<ResponseBody> loginWithEmail(String email){
        return loginService.loginWithEmail(email);
    }
}

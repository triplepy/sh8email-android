package org.triplepy.sh8email.sh8.api;


import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.api.service.EmailService;
import org.triplepy.sh8email.sh8.data.Mail;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
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
 *
 * Retrofit Client를 싱글톤으로 사용하기 위한 클래스이며
 * 메서드를 이용하여 쉽게 통신을 할 수 있습니다.
 * Dagger2를 사용하였습니다.
 *
 * @author 이강산 (river-mountain)
 *
 */
@Singleton
public class Sh8Client {
    private EmailService emailService;

    @Inject
    public Sh8Client(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient) // OkHttp에 추가적인 동작을 붙이고 싶을 때 ex) 통신로깅, 쿠키인젝션
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        emailService = retrofit.create(EmailService.class);
    }

    public Observable<ArrayList<Mail>> getMailBox(String id) {
        return emailService.getMailBox(id);
    }

    public Observable<Mail> getMailDetail(Integer number){
        return  emailService.getMailDetail(number);
    }
}

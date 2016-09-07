package org.triplepy.sh8email.sh8.api


import okhttp3.OkHttpClient
import org.triplepy.sh8email.sh8.Constants
import org.triplepy.sh8email.sh8.api.service.EmailService
import org.triplepy.sh8email.sh8.data.Mail
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

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
class Sh8Client {
    val emailService: EmailService

    @Inject
    constructor(okHttpClient: OkHttpClient) {

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        emailService = retrofit.create(EmailService::class.java)
    }

    fun getMailBox(id: String): Observable<ArrayList<Mail>> {
        return emailService.getMailBox(id)
    }

}

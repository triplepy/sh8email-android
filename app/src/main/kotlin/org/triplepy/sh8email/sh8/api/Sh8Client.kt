package org.triplepy.sh8email.sh8.api


import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.triplepy.sh8email.sh8.Constants
import org.triplepy.sh8email.sh8.api.service.EmailService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api
 * ==============================
 * Created by igangsan on 2016. 8. 28..
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

    fun getMailBox(id: String): Observable<ResponseBody> {
        return emailService.getMailBox(id)
    }

}

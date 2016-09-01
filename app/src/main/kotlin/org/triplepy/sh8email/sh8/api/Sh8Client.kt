package org.triplepy.sh8email.sh8.api


import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import org.triplepy.sh8email.sh8.Constants
import org.triplepy.sh8email.sh8.api.service.LoginService
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
    val loginService: LoginService

    @Inject
    constructor(okHttpClient: OkHttpClient) {

        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        loginService = retrofit.create<LoginService>(LoginService::class.java)
    }

    fun loginWithEmail(email: String): Observable<ResponseBody> {
        return loginService.loginWithEmail(email)
    }

}

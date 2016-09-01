package org.triplepy.sh8email.sh8.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.triplepy.sh8email.sh8.api.Sh8Client

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.module
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

@Module
class ClientModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    fun provideSh8Client(): Sh8Client {
        return Sh8Client(provideOkHttpClient())
    }
}

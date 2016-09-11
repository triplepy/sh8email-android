package org.triplepy.sh8email.sh8.api;

import org.triplepy.sh8email.sh8.api.AddCookiesInterceptor;
import org.triplepy.sh8email.sh8.api.ReceivedCookiesInterceptor;
import org.triplepy.sh8email.sh8.api.Sh8Client;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.di.module
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

@Module
public class ClientModule {
    OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(new AddCookiesInterceptor())
                .addInterceptor(new ReceivedCookiesInterceptor())
                .addInterceptor(logging).build();
    }

    @Provides
    Sh8Client provideSh8Client() {
        return new Sh8Client(getOkHttpClient());
    }
}

package org.triplepy.sh8email.sh8.api;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.app.App;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        okhttp3.Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();

            cookies.addAll(originalResponse.headers("Set-Cookie"));

            App.pref.put(Constants.PREF_COOKIE, cookies);
        }

        return originalResponse;
    }
}
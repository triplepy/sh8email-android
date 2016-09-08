package org.triplepy.sh8email.sh8.api;

import android.util.Log;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.app.App;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;

public class AddCookiesInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet<String>) App.pref.getStringSet(Constants.PREF_COOKIE, new HashSet<>());
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
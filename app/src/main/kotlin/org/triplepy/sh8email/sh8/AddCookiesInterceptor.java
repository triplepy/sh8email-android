package org.triplepy.sh8email.sh8;

import android.util.Log;

import java.io.IOException;
import java.util.HashSet;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;

@Singleton
public class AddCookiesInterceptor implements Interceptor {
    private SharedPreferencesController pref;

    @Inject
    public AddCookiesInterceptor(SharedPreferencesController pref){
        this.pref = pref;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
//            HashSet<String> preferences = (HashSet) Preferences.getDefaultPreferences().getStringSet(Preferences.PREF_COOKIES, new HashSet<>());
        HashSet<String> preferences = (HashSet) pref.getStringSet("PREF_COOKIES", new HashSet<String>());
        for (String cookie : preferences) {
            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie);
        }

        return chain.proceed(builder.build());
    }
}
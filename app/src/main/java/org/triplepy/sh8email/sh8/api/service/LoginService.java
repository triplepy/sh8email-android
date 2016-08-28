package org.triplepy.sh8email.sh8.api.service;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api.service
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("/login")
    Observable<ResponseBody> loginWithEmail(@Field("email") String email);
}

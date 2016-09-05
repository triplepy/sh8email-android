package org.triplepy.sh8email.sh8.api.service

import org.triplepy.sh8email.sh8.data.Mail
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable
import java.util.*

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api.service
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

interface EmailService {
    @FormUrlEncoded
    @POST("/rest/list/")
    fun getMailBox(@Field("recipient") id: String): Observable<ArrayList<Mail>>
}

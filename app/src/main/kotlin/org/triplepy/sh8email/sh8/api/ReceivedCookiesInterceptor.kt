package org.triplepy.sh8email.sh8.api


import okhttp3.Interceptor
import org.triplepy.sh8email.sh8.Constants
import org.triplepy.sh8email.sh8.app.App
import java.util.*

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 *
 * AddCookiesInterceptor와 마찬가지로 Interceptor를 Implements 하여 구현합니다.
 * 다른점은 request를 수행시키고 받아온 response값을 조작한다는 점 입니다.
 * 만약 response Header에 Set-Cookie란 값이 있다면 cookies값을 Preferences에 저장시킵니다.
 * 그리고는 header가 추가 된 response값을 반환시킵니다.
 *
 * @author 이강산 (river-mountain)
 *
 */

class ReceivedCookiesInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val response = chain.proceed(chain.request())

        if (!response.headers("Set-Cookie").isEmpty()) {
            val cookies = HashSet<String>()
            cookies.addAll(response.headers("Set-Cookie"))
            App.pref.put(Constants.PREF_COOKIE, cookies)
        }

        return response
    }
}
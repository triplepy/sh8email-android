package org.triplepy.sh8email.sh8.api

import okhttp3.Interceptor
import okhttp3.Response
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
 * 쿠키값을 가로채 내부에 저장해두고 매 요청마다 해당 쿠키를 심어 세션을 유지시킬 수 있습니다.
 * OkHttp의 Interceptor를 implements하면 intercept 메서드를 구현할 수 있습니다.
 * intercept에는 chain을 인자값으로 받아오는데 이 chain으로 request, response 헤더를 조작할 수 있습니다.
 * AddCookiesInterceptor에서는 chain의 request를 조작하기 위해 새로운 빌더를 만들고
 * 이전에 저장 된 쿠키값을 preferences에서 가져와 header에 추가해준 다음
 * chain에 심어 request를 요청합니다.
 * 즉, 이 과정은 request를 날리는 도중에 인터셉트되어 해당 작업을 수행 후 request 작업이 다시 진행되는 것 입니다.
 *
 * @author 이강산 (river-mountain)
 *
 */

class AddCookiesInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        val preferences = App.pref.getStringSet(Constants.PREF_COOKIE, HashSet<String>())

        for (cookie in preferences) {
            builder.addHeader("Cookie", cookie)
        }

        return chain.proceed(builder.build())
    }
}
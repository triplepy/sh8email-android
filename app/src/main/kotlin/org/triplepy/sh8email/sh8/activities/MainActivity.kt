package org.triplepy.sh8email.sh8.activities

import android.os.Bundle
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.api.Sh8Client
import org.triplepy.sh8email.sh8.ext.toast
import org.triplepy.sh8email.sh8.utils.LogAppEventUtil
import retrofit2.adapter.rxjava.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject


class MainActivity : BaseActivity() {
    @Inject
    lateinit var client: Sh8Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clientComponent.inject(this)

        client.loginWithEmail("test@naver.com")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // TODO : ResponseBody..
                    LogAppEventUtil.eventLogin("email", true)
                }, {
                    if (it is HttpException) {
                        toast("ErrorCode : ${it.code()}")
                        LogAppEventUtil.eventLogin("email", false, it.code())
                    }
                })

    }

}

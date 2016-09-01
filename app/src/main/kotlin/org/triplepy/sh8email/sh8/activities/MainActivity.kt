package org.triplepy.sh8email.sh8.activities

import android.os.Bundle
import android.util.Log
import com.crashlytics.android.Crashlytics
import com.facebook.common.logging.FLog
import io.fabric.sdk.android.Fabric
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.api.Sh8Client
import org.triplepy.sh8email.sh8.ext.toast
import org.triplepy.sh8email.sh8.utils.ReactNativeFabricLogger
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

        Fabric.with(this, Crashlytics())
        FLog.setLoggingDelegate(ReactNativeFabricLogger.getInstance())
//Warning:Conflict with dependency 'com.google.code.findbugs:jsr305'. Resolved versions for app (3.0.0) and test app (2.0.1) differ. See http://g.co/androidstudio/app-test-app-conflict for details.
        clientComponent.inject(this)

        client.loginWithEmail("test@naver.com")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // TODO : ResponseBody..
                }, {
                    if (it is HttpException) {
                        Crashlytics.log(Log.ERROR, "HttpException >> ","ErrorCode : ${it.code()}");
                        toast("ErrorCode : ${it.code()}")
                    }
                })
    }
}

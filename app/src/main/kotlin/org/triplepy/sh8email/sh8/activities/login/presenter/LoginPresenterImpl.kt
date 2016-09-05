package org.triplepy.sh8email.sh8.activities.login.presenter

import org.triplepy.sh8email.sh8.api.Sh8Client
import org.triplepy.sh8email.sh8.utils.LogAppEventUtil
import retrofit2.adapter.rxjava.HttpException
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */
class LoginPresenterImpl : LoginPresenter {
    val client: Sh8Client
    val view: LoginPresenter.View

    @Inject
    constructor(view: LoginPresenter.View, client: Sh8Client) {
        this.view = view
        this.client = client
    }

    override fun loginWithId(id: String) {
        if (id.length == 0) {
            view.showToast("아이디를 확인해주세요.")
        } else {
            view.showProgressBar()
            client.getMailBox(id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        view.hideProgressBar()
                        view.showToast("총 ${it.size}개의 메일이 있습니다.")
                        LogAppEventUtil.eventLogin("email", true)
                    }, {
                        if (it is HttpException) {
                            view.hideProgressBar()
                            view.showToast("ErrorCode : ${it.code()}")
                            LogAppEventUtil.eventLogin("email", false, it.code())
                        }
                    })
        }
    }

}
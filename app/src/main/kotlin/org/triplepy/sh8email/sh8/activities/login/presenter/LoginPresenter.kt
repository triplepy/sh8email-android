package org.triplepy.sh8email.sh8.activities.login.presenter

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */
interface LoginPresenter {
    fun loginWithId(id: String)

    interface View {
        fun showToast(message: String)
        fun showProgressBar()
        fun hideProgressBar()
    }
}
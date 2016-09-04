package org.triplepy.sh8email.sh8.activities.login

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.login_activity.*
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.activities.BaseActivity
import org.triplepy.sh8email.sh8.activities.login.di.DaggerLoginComponent
import org.triplepy.sh8email.sh8.activities.login.di.LoginModule
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter
import org.triplepy.sh8email.sh8.ext.toast
import javax.inject.Inject

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */

class LoginActivity : BaseActivity(), LoginPresenter.View {
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        DaggerLoginComponent.builder().loginModule(LoginModule(this)).build().inject(this)

        login_nextBtn.setOnClickListener {
            presenter.loginWithId(login_id.text.toString())
        }
    }

    override fun showToast(message: String) {
        toast(message)
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }
}
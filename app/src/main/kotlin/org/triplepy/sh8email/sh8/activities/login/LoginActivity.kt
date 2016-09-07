package org.triplepy.sh8email.sh8.activities.login

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.jakewharton.rxbinding.view.clicks
import kotlinx.android.synthetic.main.login_activity.*
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.activities.BaseActivity
import org.triplepy.sh8email.sh8.activities.login.di.DaggerLoginComponent
import org.triplepy.sh8email.sh8.activities.login.di.LoginModule
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter
import org.triplepy.sh8email.sh8.activities.main.MainActivity
import org.triplepy.sh8email.sh8.ext.toast
import java.util.concurrent.TimeUnit
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

    private val context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        DaggerLoginComponent.builder().loginModule(LoginModule(this)).build().inject(this)

        login_nextBtn.clicks()
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe {
                    hideSoftKeyboard()
                    presenter.loginWithId(login_id.text.toString())
                }

        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val slide = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide)
            window.exitTransition = slide


            /**
             *  hyundee - 화면 넘어 갈때 id가 커지면서 그대로 애니매이션 되도록 하고싶었다.
             *  Enable Window Content Transition - 이것 적용중
             *  인텐트로 화면 전환활때 애니매이션 넣을 view name을 넘기는데
             *  이작업을 여기서 해도 되는가 생각해보자
             * */
            // Text Animation
            val i = Intent(this, MainActivity::class.java)
            val sharedView = login_id
            val transitionName = getString(R.string.trans_login_id)
                    //id.transactionName

            val options = ActivityOptions.makeSceneTransitionAnimation(this, sharedView, transitionName)
            context?.startActivity(intent, options.toBundle())


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
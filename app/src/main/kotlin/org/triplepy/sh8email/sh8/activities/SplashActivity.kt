package org.triplepy.sh8email.sh8.activities

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.triplepy.sh8email.sh8.activities.login.LoginActivity
import org.triplepy.sh8email.sh8.ext.startActivity

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 1..
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Todo: load something

        Handler().postDelayed({
            startActivity(LoginActivity::class.java)
            supportFinishAfterTransition()
        }, 1000)
    }
}
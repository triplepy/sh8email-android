package org.triplepy.sh8email.sh8.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

open class BaseActivity : AppCompatActivity() {
    fun hideSoftKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(window.decorView.rootView.windowToken, 0)
    }
}

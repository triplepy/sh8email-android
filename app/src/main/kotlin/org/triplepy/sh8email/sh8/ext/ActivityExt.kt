package org.triplepy.sh8email.sh8.ext

import android.content.Intent
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.ext
 * ==============================
 * Created by igangsan on 2016. 8. 29..
 */

fun AppCompatActivity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun AppCompatActivity.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun AppCompatActivity.startActivity(cls: Class<*>) {
    val intent = Intent(this, cls)
    startActivity(intent)
}
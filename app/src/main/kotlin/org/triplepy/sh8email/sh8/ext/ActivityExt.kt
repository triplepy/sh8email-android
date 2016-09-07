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
 *
 * Kotlin Extension을 이용하여 메서드를 확장하는 AppCompatActivity Extension 입니다.
 * 사용법은 간단히 함수를 만들 때에 앞부분에 클래스를 지정해주면 됩니다.
 * ex) Class.methodName(){ do something }
 *
 * @author 이강산 (river-mountain)
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
package org.triplepy.sh8email.sh8.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

public class BaseActivity extends AppCompatActivity {
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);
    }
}

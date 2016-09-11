package org.triplepy.sh8email.sh8.activities.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import org.triplepy.sh8email.sh8.app.App;

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

    public String getSessionId() {
        if (App.getSessionId() != null) {
            return App.getSessionId();
        } else {
            Toast.makeText(this, "로그인 해주세요.", Toast.LENGTH_SHORT).show();
            finish();

            return null;
        }
    }
}

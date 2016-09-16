package org.triplepy.sh8email.sh8.activities.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wang.avi.AVLoadingIndicatorView;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.login.LoginActivity;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 1..
 */
public class SplashActivity extends AppCompatActivity {
    private AVLoadingIndicatorView avi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        avi= (AVLoadingIndicatorView) findViewById(R.id.avi);
        // Todo: load something
        startAnim();

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, LoginActivity.class));
            SplashActivity.this.finish();
            //supportFinishAfterTransition();
        }, 2000);

    }


    void startAnim(){
        avi.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        avi.hide();
        // or avi.smoothToHide();
    }
}
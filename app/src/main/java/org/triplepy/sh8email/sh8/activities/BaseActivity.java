package org.triplepy.sh8email.sh8.activities;

import android.support.v7.app.AppCompatActivity;

import org.triplepy.sh8email.sh8.app.App;
import org.triplepy.sh8email.sh8.di.component.ClientComponent;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 */

public class BaseActivity extends AppCompatActivity {
    protected ClientComponent getClientComponent() {
        return ((App) getApplication()).getClientComponent();
    }
}

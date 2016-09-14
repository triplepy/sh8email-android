package org.triplepy.sh8email.sh8.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxMenuItem;
import com.wang.avi.AVLoadingIndicatorView;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.base.BaseActivity;
import org.triplepy.sh8email.sh8.activities.login.di.DaggerLoginComponent;
import org.triplepy.sh8email.sh8.activities.login.di.LoginModule;
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter;
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenterImpl;
import org.triplepy.sh8email.sh8.activities.mailbox.list.MailListActivity;
import org.triplepy.sh8email.sh8.api.Sh8Client;
import org.triplepy.sh8email.sh8.app.App;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */

public class LoginActivity extends BaseActivity implements LoginPresenter.View {
    @Inject
    public LoginPresenterImpl presenter;

    @BindView(R.id.login_id)
    TextView login_id;
    @BindView(R.id.avi)
    AVLoadingIndicatorView avi;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    Sh8Client client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next_action, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RxMenuItem.clicks(item)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(v -> {
                    hideSoftKeyboard();
                    presenter.loginWithId(login_id.getText().toString());
                });
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToMain(String id) {
        App.setSessionId(id);
        Intent intent = new Intent(this, MailListActivity.class);
        startActivity(intent);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        avi.setVisibility(View.VISIBLE);
        avi.show();
    }

    @Override
    public void hideProgressBar() {
        avi.setVisibility(View.GONE);
        avi.hide();
    }

}

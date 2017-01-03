package org.triplepy.sh8email.sh8.activities.mailbox.secretcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxMenuItem;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.base.BaseActivity;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.MailDetailActivity;
import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.di.DaggerSecretCodeComponent;
import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.di.SecretCodeModule;
import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.presenter.SecretCodePresenter;
import org.triplepy.sh8email.sh8.activities.mailbox.secretcode.presenter.SecretCodePresenterImpl;
import org.triplepy.sh8email.sh8.api.Sh8Client;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static org.triplepy.sh8email.sh8.app.App.context;

/**
 * Created by jelly on 1/2/17.
 */
public class SecretCodeActivity extends BaseActivity implements SecretCodePresenter.View {
    @Inject
    Sh8Client client;
    @Inject
    SecretCodePresenterImpl presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.secret_code)
    TextView secretCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secret_code_activity);

        DaggerSecretCodeComponent.builder().secretCodeModule(new SecretCodeModule(this)).build().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next_action, menu);
        return true;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final String secretCodeValue = secretCode.getText().toString();
        if(secretCodeValue.isEmpty()) {
            showToast("비밀번호를 입력해주세요.");
            return false;
        }

        final String nickname = getIntent().getExtras().getString(Constants.EXTRAS_NICKNAME);
        final Long mailId = getIntent().getExtras().getLong(Constants.EXTRAS_MAIL_SRL);


        RxMenuItem.clicks(item)
                .throttleFirst(1500, TimeUnit.MILLISECONDS)
                .subscribe(v -> {
                    hideSoftKeyboard();
                    Intent intent = new Intent(context, MailDetailActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra(Constants.EXTRAS_NICKNAME, nickname);
                    intent.putExtra(Constants.EXTRAS_MAIL_SRL, mailId);
                    intent.putExtra(Constants.EXTRAS_SECRET_CODE, secretCodeValue);
                    context.startActivity(intent);
                });

        return super.onOptionsItemSelected(item);
    }

}

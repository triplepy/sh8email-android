package org.triplepy.sh8email.sh8.activities.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jakewharton.rxbinding.view.RxView;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.BaseActivity;
import org.triplepy.sh8email.sh8.activities.login.di.DaggerLoginComponent;
import org.triplepy.sh8email.sh8.activities.login.di.LoginModule;
import org.triplepy.sh8email.sh8.activities.login.presenter.LoginPresenter;
import org.triplepy.sh8email.sh8.activities.main.MainActivity;
import org.triplepy.sh8email.sh8.api.Sh8Client;
import org.triplepy.sh8email.sh8.data.Mail;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 */

public class LoginActivity extends BaseActivity implements LoginPresenter.View {
    @Inject
    public LoginPresenter presenter;

    private ImageButton login_nextBtn;
    private TextView login_id;
    private ProgressBar progressBar;

    @Inject
    Sh8Client client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        DaggerLoginComponent.builder().loginModule(new LoginModule(this)).build().inject(this);

        login_nextBtn = (ImageButton) findViewById(R.id.login_nextBtn);
        login_id = (TextView) findViewById(R.id.login_id);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        RxView.clicks(login_nextBtn)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(v -> {
                    hideSoftKeyboard();
                    presenter.loginWithId(login_id.getText().toString());
                });

//        setupWindowAnimations();
    }

    @Override
    public void navigateToMain(ArrayList<Mail> mails) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("list", new Gson().toJson(mails));
        startActivity(intent);
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
            getWindow().setExitTransition(slide);


            /**
             *  hyundee - 화면 넘어 갈때 id가 커지면서 그대로 애니매이션 되도록 하고싶었다.
             *  Enable Window Content Transition - 이것 적용중
             *  인텐트로 화면 전환활때 애니매이션 넣을 view name을 넘기는데
             *  이작업을 여기서 해도 되는가 생각해보자
             * */
            // Text Animation
            Intent intent = new Intent(this, MainActivity.class);
            View sharedView = login_id;
            String transitionName = getString(R.string.trans_login_id);
            //id.transactionName

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, sharedView, transitionName);
            startActivity(intent, options.toBundle());
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}

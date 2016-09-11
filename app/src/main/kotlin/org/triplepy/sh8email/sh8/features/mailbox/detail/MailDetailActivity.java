package org.triplepy.sh8email.sh8.features.mailbox.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.api.Sh8Client;
import org.triplepy.sh8email.sh8.data.Mail;
import org.triplepy.sh8email.sh8.features.mailbox.detail.di.DaggerMailDetailComponent;
import org.triplepy.sh8email.sh8.features.mailbox.detail.di.MailDetailModule;
import org.triplepy.sh8email.sh8.features.mailbox.detail.presenter.MailDetailPresenter;
import org.triplepy.sh8email.sh8.features.mailbox.detail.presenter.MailDetailPresenterImpl;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 10..
 */

public class MailDetailActivity extends AppCompatActivity implements MailDetailPresenter.View {

    @Inject
    Sh8Client client;
    @Inject
    MailDetailPresenterImpl presenter;

    @BindView(R.id.mail_contents)
    TextView mailContents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail_item);
        DaggerMailDetailComponent.builder().mailDetailModule(new MailDetailModule(this)).build().inject(this);
        ButterKnife.bind(this);

        String mailSrl = getIntent().getStringExtra(Constants.EXTRAS_MAIL_SRL);

        presenter.getMail(mailSrl);

    }

    @Override
    public void setupMail(Mail mail) {
        mailContents.setText(mail.getContents());
    }
}

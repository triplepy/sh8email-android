package org.triplepy.sh8email.sh8.activities.mailbox.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.base.BaseActivity;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.di.DaggerMailDetailComponent;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.di.MailDetailModule;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter.MailDetailPresenter;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.presenter.MailDetailPresenterImpl;
import org.triplepy.sh8email.sh8.api.Sh8Client;
import org.triplepy.sh8email.sh8.data.Mail;
import org.triplepy.sh8email.sh8.utils.TimeUtil;

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

public class MailDetailActivity extends BaseActivity implements MailDetailPresenter.View {
    @Inject
    Sh8Client client;
    @Inject
    MailDetailPresenterImpl presenter;

    @BindView(R.id.mail_detail_contents)
    TextView contents;
    @BindView(R.id.mail_detail_sender)
    TextView sender;
    @BindView(R.id.mail_detail_title)
    TextView title;
    @BindView(R.id.mail_detail_date)
    TextView date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_detail_activity);
        DaggerMailDetailComponent.builder().mailDetailModule(new MailDetailModule(this)).build().inject(this);
        ButterKnife.bind(this);

        Long mailSrl = getIntent().getExtras().getLong(Constants.EXTRAS_MAIL_SRL);
        presenter.getMail(mailSrl);
    }

    @Override
    public void setupMail(Mail mail) {
        String textTime = TimeUtil.formatTimeString(mail.getRecip_date());
        contents.setText(mail.getContents());
        sender.setText(mail.getSender());
        title.setText(mail.getSubject());
        date.setText(textTime);
    }
}

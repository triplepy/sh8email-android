package org.triplepy.sh8email.sh8.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.triplepy.sh8email.sh8.R;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities
 * ==============================
 * Created by igangsan on 2016. 9. 10..
 */

public class MailDetailActivity extends AppCompatActivity {

    private TextView mailContents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail_item);



        mailContents = (TextView) findViewById(R.id.mail_contents);



    }

}

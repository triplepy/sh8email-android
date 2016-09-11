package org.triplepy.sh8email.sh8.features.mailbox.list;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.BaseActivity;
import org.triplepy.sh8email.sh8.adapter.MailAdapter;
import org.triplepy.sh8email.sh8.data.Mail;

import java.util.ArrayList;
import java.util.Arrays;

// FIXME: MAIN ACTIVITY!

public class MailListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private MailAdapter adapter;
    private ArrayList<Mail> mails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mailJson = getIntent().getExtras().getString("list");
        Mail[] mail = new Gson().fromJson(mailJson, Mail[].class);
        mails = new ArrayList<>(Arrays.asList(mail));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.clearOnScrollListeners();

        adapter = new MailAdapter(mails, this);
        // RecyclerView setting
        recyclerView.setAdapter(adapter);



    }
}

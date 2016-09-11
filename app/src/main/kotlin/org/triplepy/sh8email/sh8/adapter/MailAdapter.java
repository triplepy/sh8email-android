package org.triplepy.sh8email.sh8.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.triplepy.sh8email.sh8.Constants;
import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.mailbox.detail.MailDetailActivity;
import org.triplepy.sh8email.sh8.data.Mail;
import org.triplepy.sh8email.sh8.utils.TimeUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.adapter
 * ==============================
 * Created by igangsan on 2016. 9. 10..
 */

public class MailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Mail> mailList;
    private Context context;

    public MailAdapter(List<Mail> mailList, Context context) {
        this.mailList = mailList;
        this.context =  context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_layout_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Mail mail = mailList.get(position);
        String textTime = TimeUtil.formatTimeString(mail.getRecip_date());

        vh.mail_list_title.setText(mail.getSubject());
        vh.mail_list_sender.setText(mail.getSender());
        vh.mail_list_date.setText(textTime);

        vh.root.setOnClickListener(v -> {
            Intent intent = new Intent(context, MailDetailActivity.class);
            intent.putExtra(Constants.EXTRAS_MAIL_SRL, mail.getPk());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.root)
        RelativeLayout root;
        @BindView(R.id.mail_list_title)
        TextView mail_list_title;
        @BindView(R.id.mail_list_date)
        TextView mail_list_date;
        @BindView(R.id.mail_list_sender)
        TextView mail_list_sender;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

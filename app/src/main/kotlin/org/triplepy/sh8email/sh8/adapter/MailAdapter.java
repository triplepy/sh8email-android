package org.triplepy.sh8email.sh8.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.triplepy.sh8email.sh8.R;
import org.triplepy.sh8email.sh8.activities.MailDetailActivity;
import org.triplepy.sh8email.sh8.data.Mail;

import java.util.List;

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

    public MailAdapter(List mailList, Context context) {
        this.mailList = mailList;
        this.context =  context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        Mail mails = mailList.get(position);
        vh.mail_detail.setText(mails.getSubject());
        vh.root.setOnClickListener(v -> {
            context.startActivity(new Intent(context, MailDetailActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return mailList.size();
    }

}

class ViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout root;
    TextView mail_detail;

    public ViewHolder(View itemView) {
        super(itemView);
        root = (RelativeLayout) itemView.findViewById(R.id.root);
        mail_detail = (TextView) itemView.findViewById(R.id.mail_detail);


    }
}

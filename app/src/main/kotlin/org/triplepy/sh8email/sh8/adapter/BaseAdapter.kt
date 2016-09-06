package org.triplepy.sh8email.sh8.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.data.Mail
import java.util.*


/**
 * Created by hyunji on 2016. 7. 31..
 */

class BaseAdapter(var c: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mailList = ArrayList<Mail>()

    //val mailList = EmailService.

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var v = LayoutInflater.from(c).inflate(R.layout.list_item
                , parent, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return mailList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
       // (holder as Item).bindData(getMailBox("id"))

    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(_list: String) {
            itemView.t_name.text = _list
        }
    }


}


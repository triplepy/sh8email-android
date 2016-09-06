package org.triplepy.sh8email.sh8.activities.main

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.transition.TransitionInflater
import kotlinx.android.synthetic.main.activity_main.*
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.activities.BaseActivity
import org.triplepy.sh8email.sh8.adapter.BaseAdapter


class MainActivity : BaseActivity() {

    private var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(R.layout.activity_main)
        setupWindowAnimations()

        // RecyclerView setting
        recyclerView.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()

        }

        // Adapter setting
        initAdapter()
    }

    private fun initAdapter() {
        if (recyclerView.adapter == null) {
            recyclerView.adapter = BaseAdapter(this)
        }

    }


    private fun setupWindowAnimations() {
        val fade = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade)
        window.exitTransition = fade
    }

}

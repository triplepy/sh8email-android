package org.triplepy.sh8email.sh8.activities.main

import android.os.Bundle
import android.transition.TransitionInflater
import org.triplepy.sh8email.sh8.R
import org.triplepy.sh8email.sh8.activities.BaseActivity


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
        val fade = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade)
        getWindow().setExitTransition(fade)
    }
}

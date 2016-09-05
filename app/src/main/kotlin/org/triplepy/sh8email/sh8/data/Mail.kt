package org.triplepy.sh8email.sh8.data

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.data
 * ==============================
 * Created by igangsan on 2016. 9. 4..
 */
data class Mail(
        val recipient: String,
        val secret_code: String,
        val sender: String,
        val subject: String,
        val contents: String,
        val recip_date: String,
        val is_read: Boolean
)
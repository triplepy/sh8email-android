package org.triplepy.sh8email.sh8.data

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.data
 * ==============================
 * Created by igangsan on 2016. 9. 4..
 *
 * 코틀린 data class를 이용한 Mail Model입니다.
 * data class는 data model을 사용할 때 구현해야하는
 * Getter Setter와 같은 보일러플레이트 코드를 사용하지 않아도
 * 즉, 롬복을 사용하지 않아도 바로 Mail 필드에 접근이 가능합니다.
 * 주로 바인딩할 경우에 val을 사용하여 final로 고정시켜주고
 * instance를 직접 생성하거나 변경 사항이 있을 때에는 var을 사용하여도 됩니다.
 *
 * @author 이강산 (river-mountain)
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
package org.triplepy.sh8email.sh8.api.service;


import org.triplepy.sh8email.sh8.data.Mail;

import java.util.ArrayList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.api.service
 * ==============================
 * Created by igangsan on 2016. 8. 28..
 * <p>
 * Retrofit을 이용한 Email 관련 통신 메서드를 정의해놓은 인터페이스 입니다.
 * GET, POST, DELETE, PUT, PATCH의 메서드 타입을 이용할 수 있고
 * Field, Path, Query 등으로 파라미터를 전송할 수 있습니다.
 * 기본적으로 사용할 리턴값은 Observable 입니다.
 * <p>
 * Retrofit을 사용하기 앞서 메서드에 따라 파라미터나 기타 전송값들이
 * HTTP 헤더, 바디 어느쪽에 위치하는지 알아두면 사용하기 좀 더 쉽습니다.
 * <p>
 * <p>
 * - @FormUrlEncoded
 * request body가 form URL encoding을 사용한다는 어노테이션입니다.
 * 파라미터로 @Fields를 사용하기 위해서는 반드시 @FormUrlEncoded를 붙여야만 합니다.
 * {@link Field @Field}.
 * 또한 이 어노테이션을 사용하면 Requests는 MIME 타입으로 application/x-www-form-urlencoded를 갖게 됩니다.
 * Filed의 name과 values는 URI-encoded에서 UTF-8로 인코딩 되며 아래의 문서를 따릅니다.
 * <a href="http://tools.ietf.org/html/rfc3986">RFC-3986</a>.
 *
 * @author 이강산 (river-mountain)
 */

public interface EmailService {
    @POST("rest/mail/{nickname}/list/")
    Observable<ArrayList<Mail>> getMailBox(@Path("nickname") String nickname);

    @FormUrlEncoded
    @POST("rest/mail/{nickname}/{mail_pk}/")
    Observable<Mail> getMailDetail(@Path("nickname") String nickname, @Path("mail_pk") Long mailPk, @Field("secret_code") String secretCode);
}

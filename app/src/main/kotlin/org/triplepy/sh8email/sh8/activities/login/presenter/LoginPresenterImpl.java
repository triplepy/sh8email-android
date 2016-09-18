package org.triplepy.sh8email.sh8.activities.login.presenter;

import org.triplepy.sh8email.sh8.api.Sh8Client;
import org.triplepy.sh8email.sh8.utils.LogAppEventUtil;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 * <p>
 * Login feature 구현부 입니다.
 *
 * @author 이강산 (river-mountain)
 */
public class LoginPresenterImpl implements LoginPresenter {
    private Sh8Client client;
    private LoginPresenter.View view;

    @Inject
    public LoginPresenterImpl(LoginPresenter.View view, Sh8Client client) {
        this.view = view;
        this.client = client;
    }

    @Override
    public void loginWithId(String id) {
        if (id.length() == 0) {
            view.showToast("아이디를 확인해주세요.");
        } else {
            view.showProgressBar();
            client.getMailBox(id)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(mails -> {
                        view.hideProgressBar();
                        if (mails.size() == 0) {
                            view.showToast(" 받아올 메일이 없습니다.");
                        } else {
                            view.showToast("총 " + mails.size() + "개의 메일이 있습니다.");
                        }
                        view.navigateToMain(id);
//                        LogAppEventUtil.eventLogin("email", true);
                    }, throwable -> {
                        if (throwable instanceof HttpException) {
                            view.hideProgressBar();
                            view.showToast("ErrorCode : " + ((HttpException) throwable).code());
                            LogAppEventUtil.eventLogin("email", false, ((HttpException) throwable).code());
                        }
                    });

        }
    }

}
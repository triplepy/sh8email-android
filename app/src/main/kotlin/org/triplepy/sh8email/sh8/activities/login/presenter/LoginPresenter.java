package org.triplepy.sh8email.sh8.activities.login.presenter;

/**
 * The sh8email-android Project.
 * ==============================
 * org.triplepy.sh8email.sh8.activities.login
 * ==============================
 * Created by igangsan on 2016. 9. 3..
 *
 * Login feature의 인터페이스 입니다.
 *
 * @author 이강산 (river-mountain)
 */
public interface LoginPresenter {
    void loginWithId(String id);

    interface View {
        void showToast(String message);
        void navigateToMain(String id);
        void showProgressBar();
        void hideProgressBar();
    }
}
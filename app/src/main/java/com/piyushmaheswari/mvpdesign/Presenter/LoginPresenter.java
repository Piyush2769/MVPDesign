package com.piyushmaheswari.mvpdesign.Presenter;

import com.piyushmaheswari.mvpdesign.Model.User;
import com.piyushmaheswari.mvpdesign.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user=new User(email,password);
        boolean isLoginSuccess=user.isValidDdata();

        if(isLoginSuccess)
            iLoginView.onLoginResult("Login Success");
        else
            iLoginView.onLoginResult("Login Failure");
    }
}

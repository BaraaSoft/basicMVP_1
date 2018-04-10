package com.baraa.bsoft.daggerloggin.login;

import android.support.annotation.Nullable;

import com.baraa.bsoft.daggerloggin.login.model.User;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    LoginActivityMVP.View view;
    LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if(view != null){
            if(view.getFirstName().equals("") || view.getLastName().equals("")){
                view.showInputError();
            }else{
                model.createUser(view.getFirstName(),view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null){
            if(view !=null)
                view.showUserNotAvailable();
        }else {
            if (view != null){
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }

    }
}

package com.baraa.bsoft.daggerloggin.login.model;

import com.baraa.bsoft.daggerloggin.login.LoginActivityMVP;
import com.baraa.bsoft.daggerloggin.login.repository.LoginRepository;

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(new User(fname,lname));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}

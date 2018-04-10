package com.baraa.bsoft.daggerloggin.login.repository;

import com.baraa.bsoft.daggerloggin.login.model.User;

public interface LoginRepository {
    User getUser();
    void saveUser(User user);
}

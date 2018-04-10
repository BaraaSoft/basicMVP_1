package com.baraa.bsoft.daggerloggin.login.repository;

import com.baraa.bsoft.daggerloggin.login.model.User;

public class MemoryRepository implements LoginRepository {
    private User user;

    @Override
    public User getUser() {
        if(user == null){
            user = new User("Baraa","Mirghani");
            user.setId(0);
            return user;
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if(user == null){
            user = getUser();
        }

        this.user = user;

    }
}

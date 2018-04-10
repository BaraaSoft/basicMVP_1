package com.baraa.bsoft.daggerloggin.root;

import com.baraa.bsoft.daggerloggin.login.LoginActivity;
import com.baraa.bsoft.daggerloggin.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}

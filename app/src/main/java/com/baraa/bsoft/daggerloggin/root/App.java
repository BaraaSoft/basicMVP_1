package com.baraa.bsoft.daggerloggin.root;

import android.app.Application;

import com.baraa.bsoft.daggerloggin.login.LoginModule;


public class App extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}

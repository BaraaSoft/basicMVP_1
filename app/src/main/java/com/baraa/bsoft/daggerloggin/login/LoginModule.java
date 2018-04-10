package com.baraa.bsoft.daggerloggin.login;

import com.baraa.bsoft.daggerloggin.login.model.LoginModel;
import com.baraa.bsoft.daggerloggin.login.repository.LoginRepository;
import com.baraa.bsoft.daggerloggin.login.repository.MemoryRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    LoginActivityMVP.Presenter providesLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    LoginActivityMVP.Model providesLoginActivityModel(LoginRepository repository){
        return new LoginModel(repository);
    }

    @Provides
    LoginRepository providesLoginRepository(){
        return new MemoryRepository();
    }


}

package com.mercari.mercaritest.di.component;


import android.app.Application;

import com.mercari.mercaritest.MercariApp;
import com.mercari.mercaritest.data.remote.NetworkModule;
import com.mercari.mercaritest.di.builder.ActivityBuilder;
import com.mercari.mercaritest.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

//todo: add more modules as activities are added
@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class, NetworkModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(MercariApp app);

}

package com.mercari.mercaritest.di.module;

import android.app.Application;
import android.content.Context;

import com.mercari.mercaritest.data.AppDataManager;
import com.mercari.mercaritest.data.DataManager;
import com.mercari.mercaritest.data.HomeHelper;
import com.mercari.mercaritest.data.NetworkModule;
import com.mercari.mercaritest.data.local.LocalHomeManager;
import com.mercari.mercaritest.utils.rx.AppSchedulerProvider;
import com.mercari.mercaritest.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    HomeHelper provideHomeHelper(LocalHomeManager localHomeManager) {
        return localHomeManager;
    }

    @Provides
    @Singleton
    NetworkModule provideNetworkModule(NetworkModule networkModule) {
        return networkModule;
    }
}

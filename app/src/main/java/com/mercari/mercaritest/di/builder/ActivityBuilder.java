package com.mercari.mercaritest.di.builder;

import com.mercari.mercaritest.ui.main.MainActivity;
import com.mercari.mercaritest.ui.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = { MainActivityModule.class})
    abstract MainActivity bindMainActivity();

}

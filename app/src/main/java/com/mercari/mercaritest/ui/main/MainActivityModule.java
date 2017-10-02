package com.mercari.mercaritest.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.GridLayoutManager;

import com.mercari.mercaritest.Config;
import com.mercari.mercaritest.ViewModelProviderFactory;
import com.mercari.mercaritest.data.DataManager;
import com.mercari.mercaritest.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainViewModel provideMainViewModel(DataManager dataManager,
                                       SchedulerProvider schedulerProvider) {
        return new MainViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    MainAdapter provideMainAdapter() {
        return new MainAdapter();
    }

    @Provides
    GridLayoutManager provideGridLayoutManager(MainActivity activity) {
        return new GridLayoutManager(activity, Config.GRID_COLUMNS);
    }

}

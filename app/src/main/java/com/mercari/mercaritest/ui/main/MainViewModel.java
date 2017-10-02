package com.mercari.mercaritest.ui.main;

import com.mercari.mercaritest.data.DataManager;
import com.mercari.mercaritest.ui.base.BaseViewModel;
import com.mercari.mercaritest.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    //TODO
    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}

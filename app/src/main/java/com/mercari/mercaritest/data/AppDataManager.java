package com.mercari.mercaritest.data;

import android.content.Context;

import com.mercari.mercaritest.data.model.HomeResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager {

    private final Context context;
    private final HomeHelper homeHelper;

    @Inject
    AppDataManager(Context context,
                   HomeHelper homeHelper) {
        this.context = context;
        this.homeHelper = homeHelper;
    }

    @Override
    public Observable<HomeResponse> getHomeData() {
        return homeHelper.getHomeData();
    }
}

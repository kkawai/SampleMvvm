package com.mercari.mercaritest.data.remote;

import com.mercari.mercaritest.data.HomeHelper;
import com.mercari.mercaritest.data.model.HomeResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class RemoteHomeManager implements HomeHelper {

    @Inject
    public RemoteHomeManager() {
    }

    @Override
    public Observable<HomeResponse> getHomeData() {
        return APIClient.getApi().getHomeData("1");
    }
}

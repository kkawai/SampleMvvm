package com.mercari.mercaritest.data.remote;

import com.mercari.mercaritest.data.HomeHelper;
import com.mercari.mercaritest.data.model.HomeResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class RemoteHomeManager implements HomeHelper {

    private APIInterface apiInterface;

    @Inject
    public RemoteHomeManager(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @Override
    public Observable<HomeResponse> getHomeData() {
        return apiInterface.getHomeData("1");
    }
}

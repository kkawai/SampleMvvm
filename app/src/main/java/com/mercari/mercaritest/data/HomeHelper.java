package com.mercari.mercaritest.data;

import com.mercari.mercaritest.data.model.HomeResponse;

import io.reactivex.Observable;

public interface HomeHelper {
    Observable<HomeResponse> getHomeData();
}

package com.mercari.mercaritest.data.remote;

import com.mercari.mercaritest.data.model.HomeResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

   @GET("/some_uri")
   Observable<HomeResponse> getHomeData(@Query("page") String page);

}
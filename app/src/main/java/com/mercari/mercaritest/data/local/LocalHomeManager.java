package com.mercari.mercaritest.data.local;

import android.content.Context;

import com.google.gson.Gson;
import com.mercari.mercaritest.data.HomeHelper;
import com.mercari.mercaritest.data.model.HomeResponse;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class LocalHomeManager implements HomeHelper {

    private final Context context;

    @Inject
    public LocalHomeManager(Context context) {
        this.context = context;
    }

    @Override
    public Observable<HomeResponse> getHomeData() {
        return Observable.fromCallable(new Callable<HomeResponse>() {
            @Override
            public HomeResponse call() throws Exception {
                InputStream is = null;
                try {
                    is = context.getAssets().open("all.json");
                    return new Gson().fromJson(new InputStreamReader(is), HomeResponse.class);
                } finally {
                    if (is != null) {
                        is.close();
                    }
                }
            }
        });
    }
}

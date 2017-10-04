package com.mercari.mercaritest.data;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mercari.mercaritest.BuildConfig;
import com.mercari.mercaritest.Config;
import com.mercari.mercaritest.data.remote.APIInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

//    @Provides
//    @Singleton
//    Cache provideHttpCache(Application application) {
//        int cacheSize = 10 * 1024 * 1024;
//        Cache cache = new Cache(application.getCacheDir(), cacheSize);
//        return cache;
//    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(/*Cache cache*/) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.DEBUG ? Config.DEBUG_BASE_API_URL : Config.PROD_BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client).build();
    }

    @Provides
    @Singleton
    APIInterface provideAPIInterface(Retrofit retrofit) {
        return retrofit.create(APIInterface.class);
    }
}

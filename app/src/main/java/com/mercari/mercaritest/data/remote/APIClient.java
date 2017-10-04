package com.mercari.mercaritest.data.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.mercari.mercaritest.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Deprecated
public class APIClient {

   private static Retrofit retrofit = null;
   private static APIInterface apiInterface = null;

   private static Retrofit getClient() {

      if (retrofit != null)
         return retrofit;

      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY :
              HttpLoggingInterceptor.Level.NONE);
      OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build();
      retrofit = new Retrofit.Builder()
            .baseUrl("https://some_domain.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client).build();
      return retrofit;
   }

   public static synchronized APIInterface getApi() {
      if (apiInterface != null)
         return apiInterface;
      apiInterface = getClient().create(APIInterface.class);
      return apiInterface;
   }
}
package io.leonardortlima.reactivex.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author leonardortlima
 * @since 2016-08-17
 */
public class Rest {

  public static SWAPIService getSWAPIService() {
    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://swapi.co/api/")
            .build();

    return retrofit.create(SWAPIService.class);
  }

}

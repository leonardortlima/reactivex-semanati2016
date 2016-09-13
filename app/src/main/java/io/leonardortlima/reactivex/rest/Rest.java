package io.leonardortlima.reactivex.rest;

import io.leonardortlima.reactivex.model.Person;
import io.leonardortlima.reactivex.model.Planet;
import io.leonardortlima.reactivex.model.SWApiResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author leonardortlima
 * @since 2016-08-17
 */
public class Rest {

  public interface SWAPIService {

    @GET("planets")
    Observable<SWApiResult<Planet>> listPlanets(
            @Query("page") Integer page
    );

    @GET("people")
    Observable<SWApiResult<Person>> listPeople(
            @Query("page") Integer page
    );

  }

  public static SWAPIService getSWAPIService() {
    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://swapi.co/api/")
            .build();

    return retrofit.create(SWAPIService.class);
  }

}

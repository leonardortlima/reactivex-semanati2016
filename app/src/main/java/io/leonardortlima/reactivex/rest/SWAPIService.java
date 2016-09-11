package io.leonardortlima.reactivex.rest;

import io.leonardortlima.reactivex.model.People;
import io.leonardortlima.reactivex.model.Planet;
import io.leonardortlima.reactivex.model.SWApiResult;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author leonardortlima
 * @since 2016-08-21
 */
public interface SWAPIService {

  @GET("planets")
  Observable<SWApiResult<Planet>> listPlanets(
          @Query("page") Integer page
  );

  @GET("people")
  Observable<SWApiResult<People>> listPeople(
          @Query("page") Integer page
  );

}

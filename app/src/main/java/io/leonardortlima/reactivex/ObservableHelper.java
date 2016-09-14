package io.leonardortlima.reactivex;

import io.leonardortlima.reactivex.model.Person;
import io.leonardortlima.reactivex.model.SWApiResult;
import io.leonardortlima.reactivex.rest.Rest;
import rx.Observable;


public class ObservableHelper {

  public static Observable<SWApiResult<Person>> getPageAndNext(Integer page) {
    return Rest.getSWAPIService().listPeople(page)
            .concatMap(swApiResult -> {
              // Terminal case.
              if (swApiResult.getNext() == null) {
                return Observable.just(swApiResult);
              } else {
                String next = swApiResult.getNext().split("=")[1];

                return Observable.just(swApiResult).concatWith(
                        getPageAndNext(Integer.valueOf(next)));
              }
            });
  }

}

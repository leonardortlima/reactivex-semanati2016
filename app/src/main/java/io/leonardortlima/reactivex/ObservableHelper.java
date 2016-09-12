package io.leonardortlima.reactivex;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import io.leonardortlima.reactivex.model.Planet;
import io.leonardortlima.reactivex.model.SWApiResult;
import io.leonardortlima.reactivex.rest.Rest;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author leonardortlima
 * @since 2016-09-11
 */
public class ObservableHelper {

  public static Observable<CharSequence> getObservableFor(final TextView textView) {

    return Observable.create(
            new Observable.OnSubscribe<CharSequence>() {
              @Override
              public void call(final Subscriber<? super CharSequence> subscriber) {

                TextWatcher textWatcher = new TextWatcher() {
                  @Override
                  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                  }

                  @Override
                  public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!subscriber.isUnsubscribed()) {
                      subscriber.onNext(s);
                    }
                  }

                  @Override
                  public void afterTextChanged(Editable s) {

                  }
                };

                textView.addTextChangedListener(textWatcher);
              }
            });
  }

  public static Observable<SWApiResult<Planet>> getPageAndNext(Integer page) {
    return Rest.getSWAPIService().listPlanets(page)
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


package io.leonardortlima.reactivex;

import org.junit.Test;

import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class Observable4Subscriber {

  Callable<Integer> callable = () -> {
    throw new Exception("Execution error!");
  };

  @Test
  public void testError() throws Exception {

    Observable.fromCallable(callable)
            .subscribe(System.out::println);
  }

  @Test
  public void testErrorSubscriber() throws Exception {
    Observable.fromCallable(callable)
            .doOnError(throwable -> System.out.println("call " + throwable.getMessage()))
            .retry(3)
            .subscribe(new Subscriber<Integer>() {
              @Override
              public void onCompleted() {
                System.out.println("onCompleted");
              }

              @Override
              public void onError(Throwable e) {
                System.out.println("onError " + e.getMessage());
              }

              @Override
              public void onNext(Integer integer) {
                System.out.println("onNext " + integer);
              }
            });
  }
}

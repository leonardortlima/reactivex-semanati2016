package io.leonardortlima.reactivex;

import org.junit.Test;

import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class Observable4Subscriber {

  Callable<Integer> callable = new Callable<Integer>() {
    @Override
    public Integer call() throws Exception {
      throw new Exception("Execution error!");
    }
  };

  @Test
  public void testError() throws Exception {

    Observable.fromCallable(callable)
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }

  @Test
  public void testErrorSubscriber() throws Exception {
    Observable.fromCallable(callable)
            .doOnError(new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                System.out.println("call " + throwable.getMessage());
              }
            })
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

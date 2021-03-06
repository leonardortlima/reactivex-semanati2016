package io.leonardortlima.reactivex;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;

public class Observable1Creation {

  @Test
  public void testJust() throws Exception {
    Observable<Integer> observable = Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    observable.subscribe(System.out::println);
  }

  @Test
  public void testJustJava7() throws Exception {
    Observable<Integer> observable = Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    observable.subscribe(System.out::println);
  }

  @Test
  public void testFrom() throws Exception {
    Integer[] items = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Observable<Integer> observable = Observable.from(items);
    observable.subscribe(System.out::println);
  }

  @Test
  public void filter() throws Exception {
    Observable<Integer> observable = Observable.range(0, 9);
    observable.subscribe(System.out::println);
  }

  @Test
  public void compact() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .subscribe(System.out::println);
  }
}

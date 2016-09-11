package io.leonardortlima.reactivex;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Observable3Filtering {

  @Test
  public void testDistinct() throws Exception {
    Observable.just(0, 0, 1, 1, 2, 2, 3, 3, 4)
            .distinct()
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }

  @Test
  public void testFirst() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .first()
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }

  @Test
  public void testLast() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .last()
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }

  @Test
  public void testFilter() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .filter(new Func1<Integer, Boolean>() {
              @Override
              public Boolean call(Integer integer) {
                return integer % 2 > 0;
              }
            })
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }
}

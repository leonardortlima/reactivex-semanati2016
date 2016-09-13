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
            .subscribe(System.out::println);
  }

  @Test
  public void testFirst() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .first()
            .subscribe(System.out::println);
  }

  @Test
  public void testLast() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .last()
            .subscribe(System.out::println);
  }

  @Test
  public void testFilter() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .filter(integer -> integer % 2 > 0)
            .subscribe(System.out::println);
  }
}

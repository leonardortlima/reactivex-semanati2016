package io.leonardortlima.reactivex;

import org.junit.Test;

import java.util.Locale;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class Observable2Transformation {

  @Test
  public void testMap() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .map(integer -> integer * 2)
            .subscribe(System.out::println);
  }
  @Test
  public void testMap2() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .map(integer -> String.format(Locale.getDefault(),
                    "%d as binary: %s", integer, Integer.toBinaryString(integer)))
            .subscribe(System.out::println);
  }

  @Test
  public void testFlatMap() throws Exception {
    Integer[] list1 = new Integer[] {0, 2, 4, 6, 8};
    Integer[] list2 = new Integer[] {1, 3, 5, 7, 9};

    Observable.just(list1, list2)
            .flatMap(Observable::from)
            .subscribe(System.out::println);
  }
}

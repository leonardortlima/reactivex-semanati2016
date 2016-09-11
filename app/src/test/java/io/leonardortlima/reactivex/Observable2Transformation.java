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
            .map(new Func1<Integer, Integer>() {
              @Override
              public Integer call(Integer integer) {
                return integer * 2;
              }
            })
            .subscribe(new Action1<Integer>() {
              @Override
              public void call(Integer x) {
                System.out.println(x);
              }
            });
  }
  @Test
  public void testMap2() throws Exception {
    Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
            .map(new Func1<Integer, String>() {
              @Override
              public String call(Integer integer) {
                return String.format(Locale.getDefault(),
                        "%d as binary: %s", integer, Integer.toBinaryString(integer));
              }
            })
            .subscribe(new Action1<String>() {
              @Override
              public void call(String x) {
                System.out.println(x);
              }
            });
  }

  @Test
  public void testFlatMap() throws Exception {
    Integer[] list1 = new Integer[] {0, 2, 4, 6, 8};
    Integer[] list2 = new Integer[] {1, 3, 5, 7, 9};

    Observable.just(list1, list2)
            .flatMap(new Func1<Integer[], Observable<Integer>>() {
              @Override
              public Observable<Integer> call(Integer[] integer) {
                return Observable.from(integer);
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

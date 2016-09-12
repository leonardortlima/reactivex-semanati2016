package io.leonardortlima.reactivex.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

import io.leonardortlima.reactivex.ObservableHelper;
import io.leonardortlima.reactivex.R;
import io.leonardortlima.reactivex.adapter.PlanetAdapter;
import io.leonardortlima.reactivex.model.Planet;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {

  private static final String TAG = "SearchActivity";

  private PlanetAdapter adapter;
  private RecyclerView recyclerView;

  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    EditText editText = (EditText) findViewById(R.id.search_box);
    recyclerView = (RecyclerView) findViewById(R.id.item_list);
    progressBar = (ProgressBar) findViewById(R.id.progress_bar);

    ObservableHelper.getObservableFor(editText)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .filter(charSequence -> {
              adapter.clearData();
              return charSequence.length() > 3;
            })
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribe(this::searchPlanet);


    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(llm);

    adapter = new PlanetAdapter();
    recyclerView.setAdapter(adapter);
  }

  private void searchPlanet(final CharSequence search) {

    ObservableHelper.getPageAndNext(null)
            .subscribeOn(Schedulers.io())
            .flatMap(planetSWApiResult -> Observable.from(planetSWApiResult.getResults()))
            .filter(planet -> planet.search(search))
            .doOnSubscribe(() ->
                    runOnUiThread(() ->
                            progressBar.setVisibility(View.VISIBLE)
                    )
            )
            .doOnCompleted(() ->
                    runOnUiThread(() ->
                            progressBar.setVisibility(View.GONE)
                    )
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Planet>() {
              @Override
              public void onCompleted() {
                Log.i(TAG, "onCompleted: search");
              }

              @Override
              public void onError(Throwable e) {
                Log.e(TAG, "onError: search", e);
              }

              @Override
              public void onNext(Planet planet) {
                Log.i(TAG, "onNext: " + planet.toString());
                adapter.addPlanet(planet);
              }
            });
  }
}

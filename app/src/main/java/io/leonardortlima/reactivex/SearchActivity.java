package io.leonardortlima.reactivex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.leonardortlima.reactivex.model.Person;
import io.leonardortlima.reactivex.model.SWApiResult;
import io.leonardortlima.reactivex.rest.Rest;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {

  private EditText mSearchEdit;
  private RecyclerView mRecyclerView;
  private PersonAdapter mPersonAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);

    mSearchEdit = (EditText) findViewById(R.id.search_text);
    mRecyclerView = (RecyclerView) findViewById(R.id.item_list);
    LinearLayoutManager llm = new LinearLayoutManager(this);
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView.setLayoutManager(llm);

    mPersonAdapter = new PersonAdapter();
    mRecyclerView.setAdapter(mPersonAdapter);

    RxTextView.textChanges(mSearchEdit)
            .filter(charSequence -> charSequence.length() > 3)
            .debounce(500, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(event -> performSearch(event.toString()));

  }

  private void performSearch(CharSequence search) {
    mPersonAdapter.clearData();

    ObservableHelper.getPageAndNext(null)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap(personSWApiResult -> Observable.from(personSWApiResult.getResults()))
            .filter(person -> person.getDetails().contains(search))
            .subscribe(person -> {
                mPersonAdapter.addPerson(person);
            });
  }
}
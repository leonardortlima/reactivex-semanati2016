package io.leonardortlima.reactivex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import io.leonardortlima.reactivex.model.Person;
import io.leonardortlima.reactivex.rest.Rest;
import rx.android.schedulers.AndroidSchedulers;
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

  }
}
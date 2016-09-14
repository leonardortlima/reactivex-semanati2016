package io.leonardortlima.reactivex;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

  private static final String TAG = "LoginActivity";

  // UI references.
  private EditText mEmailView;
  private EditText mPasswordView;
  private View mProgressView;
  private View mLoginFormView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    // Set up the login form.
    mEmailView = (EditText) findViewById(R.id.email);

    mPasswordView = (EditText) findViewById(R.id.password);
    assert mPasswordView != null;
    mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
      if (id == R.id.login || id == EditorInfo.IME_NULL) {
        attemptLogin();
        return true;
      }
      return false;
    });

    Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
    assert mEmailSignInButton != null;
    mEmailSignInButton.setOnClickListener(view -> attemptLogin());

    mLoginFormView = findViewById(R.id.login_form);
    mProgressView = findViewById(R.id.login_progress);
  }

  private void attemptLogin() {
    showProgress(true);

    Observable.fromCallable(() -> performLogin(mEmailView.getText(), mPasswordView.getText()))
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<Boolean>() {
              @Override
              public void call(Boolean aBoolean) {
                showProgress(false);
                if(aBoolean) {
                  goToSearch();
                }
              }
            });
  }


  private boolean performLogin(CharSequence username, CharSequence password) {
    try {
      // Simulate network access.
      Thread.sleep(1);
      return true;
    } catch (InterruptedException e) {
      Log.e(TAG, "performLogin: ", e);
      return false;
    }
  }

  private void goToSearch() {
    Intent intent = new Intent(this, SearchActivity.class);
    startActivity(intent);
  }

  @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
  private void showProgress(final boolean show) {
    // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
    // for very easy animations. If available, use these APIs to fade-in
    // the progress spinner.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
      int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

      mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
      mLoginFormView.animate().setDuration(shortAnimTime).alpha(
              show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
      });

      mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
      mProgressView.animate().setDuration(shortAnimTime).alpha(
              show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
          mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
      });
    } else {
      // The ViewPropertyAnimator APIs are not available, so simply show
      // and hide the relevant UI components.
      mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
      mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
    }
  }
}


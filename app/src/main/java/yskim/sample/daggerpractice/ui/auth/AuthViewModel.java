package yskim.sample.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import yskim.sample.daggerpractice.di.models.User;
import yskim.sample.daggerpractice.di.network.auth.AuthApi;

public class AuthViewModel extends ViewModel {

    // logt
    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewModel is working...");

        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(User user) {
                       Log.d(TAG, "onNext: " + user.getEmail());
                   }

                   @Override
                   public void onError(Throwable e) {
                       Log.e(TAG, "onError: ", e);
                   }

                   @Override
                   public void onComplete() {

                   }
               });


//        if(this.authApi == null) {
//            Log.d(TAG, "AuthViewModel: auth api is NULL");
//        } else {
//            Log.d(TAG, "AuthViewModel: auth api is NOT NULL");
//        }
    }
}

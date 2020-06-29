package yskim.sample.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import yskim.sample.daggerpractice.di.models.User;
import yskim.sample.daggerpractice.di.network.auth.AuthApi;

public class AuthViewModel extends ViewModel {

    // logt
    private static final String TAG = "AuthViewModel";

    private MediatorLiveData<User> authUser = new MediatorLiveData<>();

    private final AuthApi authApi;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewModel is working...");

//        authApi.getUser(1)
//                .toObservable()
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<User>() {
//                   @Override
//                   public void onSubscribe(Disposable d) {
//
//                   }
//
//                   @Override
//                   public void onNext(User user) {
//                       Log.d(TAG, "onNext: " + user.getEmail());
//                   }
//
//                   @Override
//                   public void onError(Throwable e) {
//                       Log.e(TAG, "onError: ", e);
//                   }
//
//                   @Override
//                   public void onComplete() {
//
//                   }
//               });


//        if(this.authApi == null) {
//            Log.d(TAG, "AuthViewModel: auth api is NULL");
//        } else {
//            Log.d(TAG, "AuthViewModel: auth api is NOT NULL");
//        }
    }

    public void authenticateWithId(int userId) {
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        );

        authUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observeUser() {
        return authUser;
    }
}

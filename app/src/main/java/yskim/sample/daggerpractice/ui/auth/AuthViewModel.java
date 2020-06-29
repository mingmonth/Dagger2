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
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import yskim.sample.daggerpractice.di.models.User;
import yskim.sample.daggerpractice.di.network.auth.AuthApi;

public class AuthViewModel extends ViewModel {

    // logt
    private static final String TAG = "AuthViewModel";

    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();

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

        authUser.setValue(AuthResource.loading((User)null));

        final LiveData<AuthResource<User>> source = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)

                        // instead of calling onError(error happens)
                        .onErrorReturn(new Function<Throwable, User>() {
                            @Override
                            public User apply(Throwable throwable) throws Exception {
                                User errorUser = new User();
                                errorUser.setId(-1);
                                return errorUser;
                            }
                        })

                        .map(new Function<User, AuthResource<User>>() {
                            @Override
                            public AuthResource<User> apply(User user) throws Exception {
                                if(user.getId() == -1) {
                                    return AuthResource.error("Could not authenticate", (User)null);
                                }
                                return AuthResource.authenticated(user);
                            }
                        })

                .subscribeOn(Schedulers.io())
        );

        authUser.addSource(source, new Observer<AuthResource<User>>() {
            @Override
            public void onChanged(AuthResource<User> user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<AuthResource<User>> observeUser() {
        return authUser;
    }
}

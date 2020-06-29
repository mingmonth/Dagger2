package yskim.sample.daggerpractice.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import yskim.sample.daggerpractice.di.network.auth.AuthApi;

public class AuthViewModel extends ViewModel {

    // logt
    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    @Inject
    public AuthViewModel(AuthApi authApi) {
        this.authApi = authApi;
        Log.d(TAG, "AuthViewModel: viewModel is working...");

        if(this.authApi == null) {
            Log.d(TAG, "AuthViewModel: auth api is NULL");
        } else {
            Log.d(TAG, "AuthViewModel: auth api is NOT NULL");
        }
    }
}

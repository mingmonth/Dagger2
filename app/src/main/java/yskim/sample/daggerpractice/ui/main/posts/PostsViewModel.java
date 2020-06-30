package yskim.sample.daggerpractice.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import yskim.sample.daggerpractice.SessionManager;
import yskim.sample.daggerpractice.di.network.main.MainApi;

public class PostsViewModel extends ViewModel {
    
    private static final String TAG = "PostViewModel";
    
    // inject
    private final SessionManager sessionManager;
    private final MainApi mainApi;
    
    @Inject
    public PostsViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;

        Log.d(TAG, "PostViewModel: viewmodel is working...");
        
    }
}

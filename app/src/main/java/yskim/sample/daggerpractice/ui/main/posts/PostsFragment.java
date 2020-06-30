package yskim.sample.daggerpractice.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import yskim.sample.daggerpractice.R;
import yskim.sample.daggerpractice.di.models.Post;
import yskim.sample.daggerpractice.ui.main.Resource;
import yskim.sample.daggerpractice.viewmodels.ViewModelProviderFactory;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragments";

    private PostsViewModel viewModel;
    private RecyclerView recyclerView;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        viewModel = new ViewModelProvider(this, providerFactory).get(PostsViewModel.class);
        subscribeObservers();
    }

    private void subscribeObservers() {
        viewModel.observePosts().removeObservers(getViewLifecycleOwner());
        viewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if(listResource != null) {
                    Log.d(TAG, "onChanged: " + listResource.data);
                }
            }
        });
    }
}

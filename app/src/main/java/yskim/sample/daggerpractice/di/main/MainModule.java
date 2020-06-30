package yskim.sample.daggerpractice.di.main;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import yskim.sample.daggerpractice.di.network.main.MainApi;
import yskim.sample.daggerpractice.ui.main.posts.PostsRecyclerAdapter;

@Module
public class MainModule {

    @Provides
    static PostsRecyclerAdapter provideAdapter() {
        return new PostsRecyclerAdapter();
    }

    @Provides
    static MainApi provideMainApi(Retrofit retrofit) {
        return retrofit.create(MainApi.class);
    }
}

package yskim.sample.daggerpractice.di.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import yskim.sample.daggerpractice.ui.main.posts.PostsFragment;
import yskim.sample.daggerpractice.ui.main.profile.ProfileFragment;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragment contributePostsFragment();
}

package yskim.sample.daggerpractice.di.main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import yskim.sample.daggerpractice.ui.profile.ProfileFragment;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();
}

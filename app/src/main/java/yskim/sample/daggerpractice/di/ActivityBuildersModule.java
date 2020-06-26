package yskim.sample.daggerpractice.di;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import yskim.sample.daggerpractice.AuthActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

}

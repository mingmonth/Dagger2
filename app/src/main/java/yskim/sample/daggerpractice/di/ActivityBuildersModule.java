package yskim.sample.daggerpractice.di;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import yskim.sample.daggerpractice.di.auth.AuthViewModelsModule;
import yskim.sample.daggerpractice.ui.auth.AuthActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

}

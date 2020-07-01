package yskim.sample.daggerpractice.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import yskim.sample.daggerpractice.di.auth.AuthModule;
import yskim.sample.daggerpractice.di.auth.AuthScope;
import yskim.sample.daggerpractice.di.auth.AuthViewModelsModule;
import yskim.sample.daggerpractice.di.main.MainFragmentBuildersModule;
import yskim.sample.daggerpractice.di.main.MainModule;
import yskim.sample.daggerpractice.di.main.MainScope;
import yskim.sample.daggerpractice.di.main.MainViewModelModule;
import yskim.sample.daggerpractice.ui.auth.AuthActivity;
import yskim.sample.daggerpractice.ui.main.MainActivity;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

//    @Binds
//    @IntoMap
//    @ClassKey(AuthActivity.class)
//    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
//            AuthActivitySubcomponent.Factory builder);
//
//    @Subcomponent(modules = AuthViewModelsModule.class)
//    public interface AuthActivitySubcomponent extends AndroidInjector<AuthActivity> {
//        @Subcomponent.Factory
//        interface Factory extends AndroidInjector.Factory<AuthActivity> {}
//    }

}

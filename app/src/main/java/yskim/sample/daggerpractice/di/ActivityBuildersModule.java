package yskim.sample.daggerpractice.di;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import yskim.sample.daggerpractice.di.auth.AuthViewModelsModule;
import yskim.sample.daggerpractice.ui.auth.AuthActivity;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelsModule.class}
    )
    abstract AuthActivity contributeAuthActivity();

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

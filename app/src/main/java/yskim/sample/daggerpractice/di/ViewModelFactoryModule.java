package yskim.sample.daggerpractice.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import yskim.sample.daggerpractice.viewmodels.ViewModelProviderFactory;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory modelProviderFactory);

//    @Provides
//    static ViewModelProvider.Factory bindfactory(ViewModelProviderFactory factory) {
//
//        return factory;
//    }
}

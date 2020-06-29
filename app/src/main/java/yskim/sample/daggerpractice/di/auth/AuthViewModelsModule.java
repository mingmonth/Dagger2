package yskim.sample.daggerpractice.di.auth;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import yskim.sample.daggerpractice.di.ViewModelKey;
import yskim.sample.daggerpractice.ui.auth.AuthViewModel;

@Module
public abstract class AuthViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);

//    @Binds
//    @IntoMap
//    @ViewModelKey(MainViewModel.class)
//    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);

}

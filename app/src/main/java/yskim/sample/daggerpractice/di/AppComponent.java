package yskim.sample.daggerpractice.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
//import yskim.sample.daggerpractice.AuthActivity;
import yskim.sample.daggerpractice.BaseApplication;
import yskim.sample.daggerpractice.SessionManager;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
                ViewModelFactoryModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

//    void inject(AuthActivity activity);

//    ActivityBuildersModule.AuthActivitySubcomponent.Factory authSub();

    SessionManager sessionManager();

    @Component.Builder
    interface Builder {

//        @BindsInstance
//        Builder whatever(Application application);

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

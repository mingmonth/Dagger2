package yskim.sample.daggerpractice.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import yskim.sample.daggerpractice.AuthActivity;
import yskim.sample.daggerpractice.BaseApplication;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuildersModule.class,
                AppModule.class,
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

//    void inject(AuthActivity activity);

    @Component.Builder
    interface Builder {

//        @BindsInstance
//        Builder whatever(Application application);

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

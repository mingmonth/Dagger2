package yskim.sample.daggerpractice.di;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import yskim.sample.daggerpractice.BaseApplication;

@Component(
        modules = {
                AndroidSupportInjectionModule.class,

        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

//        @BindsInstance
//        Builder whatever(Application application);

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

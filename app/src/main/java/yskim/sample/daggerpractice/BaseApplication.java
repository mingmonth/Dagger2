package yskim.sample.daggerpractice;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import yskim.sample.daggerpractice.di.DaggerAppComponent;

public class BaseApplication extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
        //return DaggerAppComponent.builder().whatever(this).build();
    }
}

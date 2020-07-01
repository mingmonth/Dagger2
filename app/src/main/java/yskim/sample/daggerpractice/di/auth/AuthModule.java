package yskim.sample.daggerpractice.di.auth;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import yskim.sample.daggerpractice.di.models.User;
import yskim.sample.daggerpractice.di.network.auth.AuthApi;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    @Named("auth_user")
    static User someUser() {
        return new User();
    }

    @AuthScope
    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}

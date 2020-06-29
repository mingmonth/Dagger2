package yskim.sample.daggerpractice.di.auth;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import yskim.sample.daggerpractice.di.network.auth.AuthApi;

@Module
public class AuthModule {

    @Provides
    static AuthApi provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthApi.class);
    }
}

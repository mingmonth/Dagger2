package yskim.sample.daggerpractice.di.network.auth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AuthApi {

    @GET
    Call<ResponseBody> getFakeStuff();
}
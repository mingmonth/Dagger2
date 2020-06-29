package yskim.sample.daggerpractice.di.network.auth;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import yskim.sample.daggerpractice.di.models.User;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );

    /*@GET
    Call<ResponseBody> getFakeStuff();

    @GET
    Flowable<ResponseBody> getFakeStuff();*/
}

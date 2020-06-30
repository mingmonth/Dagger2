package yskim.sample.daggerpractice.di.network.main;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yskim.sample.daggerpractice.di.models.Post;

public interface MainApi {

    // posts?userId=1
    @GET("posts")
    Flowable<List<Post>> getPostsFromUser(
            @Query("userId") int id
    );
}

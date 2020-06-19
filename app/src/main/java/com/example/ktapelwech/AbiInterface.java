package com.example.ktapelwech;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

//interface for set and get
public interface AbiInterface {
    //get for post
    @GET("posts/{id}")
    public Call<Post> getpost(@Path("id") int postId);

    //get for list
    @GET("posts")
    public Call<List<Post>> getpost(@Query("userId") String userId);

    @POST("posts")
    public Call<Post> storePost(@Body Post post);

    @POST("posts")
    public Call<Post> storePost(@Body HashMap<Object,Object> map);
}

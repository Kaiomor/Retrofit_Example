package com.example.kaio_.entendotudo.Config;

import com.example.kaio_.entendotudo.Pojos.Posts;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/posts")
    Call<List<Posts>>getPosts();

}

package dev.ronnie.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("v3/sports")
    Call<Data> getData(@Query("apiKey") String api);

}

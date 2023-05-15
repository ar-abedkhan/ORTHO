package com.abedkhan.ortho.ApiRetrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiSet {

    @FormUrlEncoded
    @POST("logein.php")
    Call<ResponseModel> veryfyUser(
            @Field("email") String email,
            @Field("password") String pass
    );
}

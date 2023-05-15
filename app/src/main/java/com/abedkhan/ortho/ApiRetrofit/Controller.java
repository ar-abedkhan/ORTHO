package com.abedkhan.ortho.ApiRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    private static final String url1="http://192.168.0.114/php/";
    private static Controller clientObject;
    private static Retrofit retrofit;

    Controller(){
        retrofit=new Retrofit.Builder()
                .baseUrl(url1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized Controller getInstance()
    {
        if (clientObject==null)
            clientObject=new Controller();
            return clientObject;

    }

   public ApiSet getApi(){
       return retrofit.create(ApiSet.class);
   }

}

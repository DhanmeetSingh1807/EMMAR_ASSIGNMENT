package com.example.emmar_assignment.ui.network;

import static com.example.emmar_assignment.ui.utils.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Dhanmeet on 11/08/23.
 */
public class RetrofitClient {
    private static Retrofit retrofit;

    // getting service instance for making api calls
    public static ApiDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiDataService.class);
    }
}
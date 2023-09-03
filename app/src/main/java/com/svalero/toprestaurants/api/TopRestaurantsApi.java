package com.svalero.toprestaurants.api;

import static com.svalero.toprestaurants.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopRestaurantsApi {

    public static TopRestaurantsApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(TopRestaurantsApiInterface.class);
    }
}

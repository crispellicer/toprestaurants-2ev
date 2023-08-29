package com.svalero.toprestaurants.model.restaurants;

import android.content.Context;
import android.util.Log;


import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.restaurants.RestaurantsListContract;
import com.svalero.toprestaurants.domain.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsListModel implements RestaurantsListContract.Model {

    private Context context;

    public RestaurantsListModel(Context context) {
        this.context = context;
    }


    @Override
    public void loadAllRestaurants(OnLoadRestaurantsListener listener) {
        TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
        Call<List<Restaurant>> callRestaurants = topRestaurantsApi.getRestaurants();
        Log.d("restaurants", "Llamada desde model");
        callRestaurants.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                Log.d("restaurants", "Llamada desde model ok");
                List<Restaurant> restaurants = response.body();
                listener.onLoadRestaurantsSuccess(restaurants);

            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Log.d("restaurants", "Llamada desde model error");
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadRestaurantsError(message);
            }
        });
    }

    @Override
    public List<Restaurant> loadRestaurantsByName(String name) {
        return null;
    }

    @Override
    public boolean deleteRestaurant(String name) {
        return false;
    }
}

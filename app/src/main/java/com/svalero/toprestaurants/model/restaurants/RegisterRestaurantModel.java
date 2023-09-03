package com.svalero.toprestaurants.model.restaurants;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.restaurants.RegisterRestaurantContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterRestaurantModel implements RegisterRestaurantContract.Model {

    private Context context;

    public RegisterRestaurantModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean registerRestaurant(Restaurant restaurant, OnRegisterRestaurantListener listener) {
        try {
            TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
            Call<Restaurant> callRestaurants = topRestaurantsApi.addRestaurant(restaurant);
            callRestaurants.enqueue(new Callback<Restaurant>() {
                @Override
                public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                    Restaurant restaurant = response.body();
                    listener.onRegisterSuccess(restaurant);

                }

                @Override
                public void onFailure(Call<Restaurant> call, Throwable t) {
                    String message = "Error invocando a la operación";
                    listener.onRegisterError(message);
                }
            });
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}

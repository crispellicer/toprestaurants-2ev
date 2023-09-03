package com.svalero.toprestaurants.model.restaurants;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.contract.restaurants.ModifyRestaurantContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.customers.ModifyCustomerPresenter;
import com.svalero.toprestaurants.presenter.restaurants.ModifyRestaurantPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyRestaurantModel implements ModifyRestaurantContract.Model {

    private ModifyRestaurantPresenter presenter;

    @Override
    public void modifyRestaurant(long id, Restaurant restaurant, OnModifyRestaurantListener listener) {

        try {
            TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
            Call<Restaurant> callRestaurants = topRestaurantsApi.modifyRestaurant(id, restaurant);
            callRestaurants.enqueue(new Callback<Restaurant>() {
                @Override
                public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {
                    listener.onModifySuccess(restaurant);
                }

                @Override
                public void onFailure(Call<Restaurant> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error al invocar la operación";
                    listener.onModifyError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}

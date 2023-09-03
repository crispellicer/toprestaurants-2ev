package com.svalero.toprestaurants.model.restaurants;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.restaurants.DeleteRestaurantContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteRestaurantModel implements DeleteRestaurantContract.Model {

    @Override
    public void deleteRestaurant(long id, OnDeleteRestaurantListener listener) {
        try {
            TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
            Call<Void> callRestaurants = topRestaurantsApi.deleteRestaurant(id);
            callRestaurants.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    listener.onDeleteSuccess();

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    String message = "Error invocando a la operación";
                    listener.onDeleteError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}

package com.svalero.toprestaurants.model.restaurants;

import android.content.Context;

import com.svalero.toprestaurants.contract.restaurants.RestaurantDetailsContract;
import com.svalero.toprestaurants.domain.Restaurant;

public class RestaurantDetailsModel implements RestaurantDetailsContract.Model {

    private Context context;

    public RestaurantDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //return db.restaurantDao().getByName(name);
        return null;
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //return db.restaurantDao().getById(id);
        return null;
    }
}

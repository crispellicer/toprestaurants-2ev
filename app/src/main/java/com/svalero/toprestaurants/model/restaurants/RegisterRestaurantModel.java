package com.svalero.toprestaurants.model.restaurants;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.svalero.toprestaurants.contract.restaurants.RegisterRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;

public class RegisterRestaurantModel implements RegisterRestaurantContract.Model {

    private Context context;

    public RegisterRestaurantModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean registerRestaurant(Restaurant restaurant) {
        try {
            //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
              //      .allowMainThreadQueries().build();
            //db.restaurantDao().insert(restaurant);
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}

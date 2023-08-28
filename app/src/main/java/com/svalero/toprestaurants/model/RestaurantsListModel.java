package com.svalero.toprestaurants.model;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.RestaurantsListContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Restaurant;

import java.util.List;

public class RestaurantsListModel implements RestaurantsListContract.Model {

    private Context context;

    public RestaurantsListModel(Context context) {
        this.context = context;
    }

    @Override
    public List<Restaurant> loadAllRestaurants() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.restaurantDao().getAll();
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

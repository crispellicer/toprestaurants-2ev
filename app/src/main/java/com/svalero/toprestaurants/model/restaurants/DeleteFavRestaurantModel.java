package com.svalero.toprestaurants.model.restaurants;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.restaurants.DeleteFavRestaurantContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.FavRestaurant;

public class DeleteFavRestaurantModel implements DeleteFavRestaurantContract.Model {

    public Context context;

    public DeleteFavRestaurantModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean deleteFavRestaurant(FavRestaurant favRestaurant) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        db.favRestaurantDao().delete(favRestaurant);
        return true;
    }
}

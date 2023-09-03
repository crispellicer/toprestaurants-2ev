package com.svalero.toprestaurants.model.restaurants;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.restaurants.AddFavRestaurantContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.FavRestaurant;

public class AddFavRestaurantModel implements AddFavRestaurantContract.Model {

    private Context context;

    public AddFavRestaurantModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean addFavRestaurant(FavRestaurant favRestaurant) {
        try {
            final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
            db.favRestaurantDao().insert(favRestaurant);
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}

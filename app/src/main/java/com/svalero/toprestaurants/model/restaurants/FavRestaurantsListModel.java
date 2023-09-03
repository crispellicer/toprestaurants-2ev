package com.svalero.toprestaurants.model.restaurants;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.restaurants.FavRestaurantsListContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.FavRestaurant;

import java.util.List;

public class FavRestaurantsListModel implements FavRestaurantsListContract.Model {
    private Context context;

    public FavRestaurantsListModel(Context context) {
        this.context = context;
    }

    @Override
    public List<FavRestaurant> loadAllFavRestaurants() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.favRestaurantDao().getAll();
    }
}

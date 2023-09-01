package com.svalero.toprestaurants.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.svalero.toprestaurants.domain.FavRestaurant;

@Database(entities ={FavRestaurant.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavRestaurantDao favRestaurantDao();
}

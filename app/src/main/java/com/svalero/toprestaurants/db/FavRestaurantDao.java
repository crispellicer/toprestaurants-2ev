package com.svalero.toprestaurants.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.svalero.toprestaurants.domain.FavRestaurant;

import java.util.List;

@Dao
public interface FavRestaurantDao {

    @Query(value = "SELECT * FROM FavRestaurant")
    List<FavRestaurant> getAll();

    @Insert
    void insert(FavRestaurant favRestaurant);

    @Delete
    void delete(FavRestaurant favRestaurant);

    @Update
    void update(FavRestaurant favRestaurant);
}

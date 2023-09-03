package com.svalero.toprestaurants.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.view.customers.CustomersListView;
import com.svalero.toprestaurants.view.restaurants.FavRestaurantsListView;
import com.svalero.toprestaurants.view.restaurants.RestaurantsListView;

public class MainActivity extends AppCompatActivity {

    Button restaurantsList;
    Button customersList;
    Button favRestaurantsList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantsList = findViewById(R.id.restaurants_list_button);
        restaurantsList.setOnClickListener(view -> {
            Intent intent = new Intent(this, RestaurantsListView.class);
            startActivity(intent);
        });

        customersList = findViewById(R.id.customers_list_button);
        customersList.setOnClickListener(view -> {
            Intent intent = new Intent(this, CustomersListView.class);
            startActivity(intent);
        });

        favRestaurantsList = findViewById(R.id.fav_restaurants_list_button);
        favRestaurantsList.setOnClickListener(view -> {
            Intent intent = new Intent(this, FavRestaurantsListView.class);
            startActivity(intent);
        });
    }
}
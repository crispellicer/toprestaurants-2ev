package com.svalero.toprestaurants.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.view.customers.CustomersListView;
import com.svalero.toprestaurants.view.reserves.ReservesListView;
import com.svalero.toprestaurants.view.restaurants.RestaurantsListView;

public class MainActivity extends AppCompatActivity {

    Button restaurantsList;
    Button customersList;
    Button reservesList;

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

        reservesList = findViewById(R.id.reserves_list_button);
        reservesList.setOnClickListener(view -> {
            Intent intent = new Intent(this, ReservesListView.class);
            startActivity(intent);
        });
    }
}
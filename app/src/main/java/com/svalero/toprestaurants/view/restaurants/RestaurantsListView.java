package com.svalero.toprestaurants.view.restaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.adapter.RestaurantAdapter;
import com.svalero.toprestaurants.contract.restaurants.RestaurantsListContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.presenter.restaurants.RestaurantsListPresenter;
import com.svalero.toprestaurants.view.MapsActivity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsListView extends AppCompatActivity implements RestaurantsListContract.View{

    private List<Restaurant> restaurantsList;
    private RestaurantAdapter adapter;
    private RestaurantsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list_view);

        presenter = new RestaurantsListPresenter(this);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        restaurantsList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.restaurants_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RestaurantAdapter(this, restaurantsList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllRestaurants();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_rest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.register_restaurant) {
            Intent intent = new Intent(this, RegisterRestaurantView.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.view_map) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        }

        return false;
    }

    public void goBackButton(View view) {
        onBackPressed();
    }

    @Override
    public void showRestaurants(List<Restaurant> restaurants) {
        restaurantsList.clear();
        restaurantsList.addAll(restaurants);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {

    }
}
package com.svalero.toprestaurants.view.restaurants;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.toprestaurants.R;
import com.svalero.toprestaurants.adapter.FavRestaurantAdapter;
import com.svalero.toprestaurants.contract.restaurants.FavRestaurantsListContract;
import com.svalero.toprestaurants.domain.FavRestaurant;
import com.svalero.toprestaurants.presenter.restaurants.FavRestaurantsListPresenter;

import java.util.ArrayList;
import java.util.List;

public class FavRestaurantsListView extends AppCompatActivity implements FavRestaurantsListContract.View {

    private List<FavRestaurant> favRestaurantsList;
    private FavRestaurantAdapter adapter;
    private FavRestaurantsListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_restaurants_list_view);

        presenter = new FavRestaurantsListPresenter(this);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        favRestaurantsList = new ArrayList<>();

        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.fav_restaurants_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FavRestaurantAdapter(this, favRestaurantsList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.loadAllFavRestaurants();

    }

    public void showFavRestaurants(List<FavRestaurant> favRestaurants) {
        favRestaurantsList.clear();
        favRestaurantsList.addAll(favRestaurants);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    public void goBackButton(View view) {
        onBackPressed();
    }

}

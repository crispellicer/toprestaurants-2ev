package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.customers.CustomersListContract;
import com.svalero.toprestaurants.contract.restaurants.RestaurantsListContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.restaurants.RestaurantsListModel;
import com.svalero.toprestaurants.view.restaurants.RestaurantsListView;

import java.util.List;

public class RestaurantsListPresenter implements RestaurantsListContract.Presenter,
        RestaurantsListContract.Model.OnLoadRestaurantsListener{

    private RestaurantsListModel model;
    private RestaurantsListView view;

    public RestaurantsListPresenter(RestaurantsListView view) {
        this.view = view;
        this.model = new RestaurantsListModel(view.getApplicationContext());

    }

    @Override
    public void loadAllRestaurants() {
        model.loadAllRestaurants(this);
    }

    @Override
    public void loadRestaurantsByName(String name) {

    }

    @Override
    public void deleteRestaurant(String name) {

    }

    @Override
    public void onLoadRestaurantsSuccess(List<Restaurant> restaurants) {
        view.showRestaurants(restaurants);
    }

    @Override
    public void onLoadRestaurantsError(String message) {
        view.showMessage(message);
    }
}

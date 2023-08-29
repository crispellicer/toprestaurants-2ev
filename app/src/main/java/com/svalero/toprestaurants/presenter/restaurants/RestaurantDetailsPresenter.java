package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.restaurants.RestaurantDetailsContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.restaurants.RestaurantDetailsModel;
import com.svalero.toprestaurants.view.restaurants.RestaurantDetailsView;

public class RestaurantDetailsPresenter implements RestaurantDetailsContract.Presenter {

    private RestaurantDetailsModel model;
    private RestaurantDetailsView view;

    public RestaurantDetailsPresenter(RestaurantDetailsView view) {
        model = new RestaurantDetailsModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadRestaurant(String name) {
        Restaurant restaurant = model.getRestaurantByName(name);
        view.showRestaurant(restaurant);
    }
}

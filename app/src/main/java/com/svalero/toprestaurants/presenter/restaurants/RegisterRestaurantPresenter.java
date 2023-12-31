package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.restaurants.RegisterRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.restaurants.RegisterRestaurantModel;
import com.svalero.toprestaurants.view.restaurants.RegisterRestaurantView;

public class RegisterRestaurantPresenter implements RegisterRestaurantContract.Presenter,
        RegisterRestaurantContract.Model.OnRegisterRestaurantListener{

    private RegisterRestaurantModel model;
    private RegisterRestaurantView view;

    public RegisterRestaurantPresenter(RegisterRestaurantView view) {
        model = new RegisterRestaurantModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        model.registerRestaurant(restaurant, this);
    }

    @Override
    public void onRegisterSuccess(Restaurant restaurant) {
        view.showMessage("Restaurant " + restaurant.getId() + " has been registered");
    }

    @Override
    public void onRegisterError(String message) {
        view.showError("An error has occurred");
    }
}

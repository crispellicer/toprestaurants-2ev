package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.restaurants.ModifyRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.restaurants.ModifyRestaurantModel;
import com.svalero.toprestaurants.view.restaurants.ModifyRestaurantView;

public class ModifyRestaurantPresenter implements ModifyRestaurantContract.Presenter,
        ModifyRestaurantContract.Model.OnModifyRestaurantListener {

    private ModifyRestaurantModel model;
    private ModifyRestaurantView view;

    public ModifyRestaurantPresenter(ModifyRestaurantView view) {
        this.model = new ModifyRestaurantModel();
        this.view = view;
    }

    @Override
    public void modifyRestaurant(long id, Restaurant restaurant) {
        model.modifyRestaurant(id, restaurant, this);
    }

    @Override
    public void onModifySuccess(Restaurant restaurant) {
        view.showMessage("The restaurant has been successfully modified");
    }

    @Override
    public void onModifyError(String message) {
        view.showError("An error has occurred");
    }
}

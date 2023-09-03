package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.adapter.RestaurantAdapter;
import com.svalero.toprestaurants.contract.restaurants.DeleteRestaurantContract;
import com.svalero.toprestaurants.model.restaurants.DeleteRestaurantModel;

public class DeleteRestaurantPresenter implements DeleteRestaurantContract.Presenter,
    DeleteRestaurantContract.Model.OnDeleteRestaurantListener {

    private DeleteRestaurantModel model;
    private RestaurantAdapter view;

    public DeleteRestaurantPresenter(RestaurantAdapter view) {
        model = new DeleteRestaurantModel();
        this.view = view;
    }

    @Override
    public void deleteRestaurant(long id) {
        model.deleteRestaurant(id, this);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("Customer has been successfully removed");
    }

    @Override
    public void onDeleteError(String message) {
        view.showError("An error has occurred");
    }
}

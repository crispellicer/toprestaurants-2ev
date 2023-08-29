package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.restaurants.RegisterRestaurantContract;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.restaurants.RegisterRestaurantModel;
import com.svalero.toprestaurants.view.restaurants.RegisterRestaurantView;

public class RegisterRestaurantPresenter implements RegisterRestaurantContract.Presenter {

    private RegisterRestaurantModel model;
    private RegisterRestaurantView view;

    public RegisterRestaurantPresenter(RegisterRestaurantView view) {
        model = new RegisterRestaurantModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void registerRestaurant(Restaurant restaurant) {
        boolean done = model.registerRestaurant(restaurant);
        if (done) {
            view.showMessage("Restaurante registrado correctamente");
            view.resetForm();
        } else {
            view.showError("Se ha producido un error al registrar el restaurante. Comprueba que los datos son correctos");
        }
    }
}

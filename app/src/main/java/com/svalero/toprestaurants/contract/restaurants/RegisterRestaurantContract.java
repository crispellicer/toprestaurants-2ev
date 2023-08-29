package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.Restaurant;

public interface RegisterRestaurantContract {

    interface Model {
        boolean registerRestaurant(Restaurant restaurant);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm();
    }

    interface Presenter {
        void registerRestaurant(Restaurant restaurant);
    }
}

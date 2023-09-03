package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;

public interface RegisterRestaurantContract {

    interface Model {
        interface OnRegisterRestaurantListener {
            void onRegisterSuccess(Restaurant restaurant);
            void onRegisterError(String message);
        }
        boolean registerRestaurant(Restaurant restaurant, OnRegisterRestaurantListener listener);
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

package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.FavRestaurant;

public interface AddFavRestaurantContract {

    interface Model {
        boolean addFavRestaurant(FavRestaurant favRestaurant);
    }

    interface View {
        void showError(String errorMessage);

        void showMessage(String message);
    }

    interface Presenter {
        void addFavRestaurant(FavRestaurant favRestaurant);

    }
}

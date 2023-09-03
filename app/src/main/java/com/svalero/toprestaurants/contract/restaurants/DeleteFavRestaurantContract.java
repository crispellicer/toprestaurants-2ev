package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.FavRestaurant;

public interface DeleteFavRestaurantContract {

    interface Model {
        boolean deleteFavRestaurant(FavRestaurant favRestaurant);
    }

    interface View {
        void showMessage(String message);
    }

    interface Presenter {
        void deleteFavRestaurant(FavRestaurant favRestaurant);

    }
}

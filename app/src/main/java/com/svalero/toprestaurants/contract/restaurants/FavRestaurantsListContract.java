package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.FavRestaurant;

import java.util.List;

public interface FavRestaurantsListContract {

    interface Model {
        List<FavRestaurant> loadAllFavRestaurants();
    }

    interface View {
        void showFavRestaurants(List<FavRestaurant> favRestaurants);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllFavRestaurants();
    }
}

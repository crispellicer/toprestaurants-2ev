package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.Restaurant;

import java.util.List;

public interface RestaurantsListContract {

    interface Model {
        List<Restaurant> loadAllRestaurants();
        List<Restaurant> loadRestaurantsByName(String name);
        boolean deleteRestaurant(String name);
    }

    interface View {
        void showRestaurants(List<Restaurant> restaurants);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllRestaurants();
        void loadRestaurantsByName(String name);
        void deleteRestaurant(String name);
    }
}

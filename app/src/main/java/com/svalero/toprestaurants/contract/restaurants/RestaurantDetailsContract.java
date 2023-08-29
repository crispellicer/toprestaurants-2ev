package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.Restaurant;

public interface RestaurantDetailsContract {

    interface Model {
        Restaurant getRestaurantByName(String name);
        Restaurant getRestaurantById(long id);
    }

    interface View {
        void showRestaurant(Restaurant restaurant);
    }

    interface Presenter {
        void loadRestaurant(String name);
    }
}

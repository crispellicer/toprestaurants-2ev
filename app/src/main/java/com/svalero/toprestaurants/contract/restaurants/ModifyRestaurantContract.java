package com.svalero.toprestaurants.contract.restaurants;

import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Restaurant;

public interface ModifyRestaurantContract {

    interface Model {
        interface OnModifyRestaurantListener {
            void onModifySuccess(Restaurant restaurant);
            void onModifyError(String message);
        }
        void modifyRestaurant (long id, Restaurant restaurant, ModifyRestaurantContract.Model.OnModifyRestaurantListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void modifyRestaurant(long id, Restaurant restaurant);
    }
}

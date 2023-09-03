package com.svalero.toprestaurants.contract.restaurants;


public interface DeleteRestaurantContract {

    interface Model {
        interface OnDeleteRestaurantListener {
            void onDeleteSuccess();
            void onDeleteError(String message);
        }
        void deleteRestaurant(long id, OnDeleteRestaurantListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void deleteRestaurant(long id);
    }
}

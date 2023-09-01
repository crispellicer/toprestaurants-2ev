package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.adapter.FavRestaurantAdapter;
import com.svalero.toprestaurants.contract.restaurants.DeleteFavRestaurantContract;
import com.svalero.toprestaurants.domain.FavRestaurant;
import com.svalero.toprestaurants.model.restaurants.DeleteFavRestaurantModel;

public class DeleteFavRestaurantPresenter implements DeleteFavRestaurantContract.Presenter {

    private DeleteFavRestaurantModel model;
    private FavRestaurantAdapter view;

    public DeleteFavRestaurantPresenter(DeleteFavRestaurantModel model, FavRestaurantAdapter view) {
        this.model = new DeleteFavRestaurantModel(view.getContext());
        this.view = view;
    }

    @Override
    public void deleteFavRestaurant(FavRestaurant favRestaurant) {
        model.deleteFavRestaurant(favRestaurant);
    }
}

package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.adapter.RestaurantAdapter;
import com.svalero.toprestaurants.contract.restaurants.AddFavRestaurantContract;
import com.svalero.toprestaurants.domain.FavRestaurant;
import com.svalero.toprestaurants.model.restaurants.AddFavRestaurantModel;

public class AddFavRestaurantPresenter implements AddFavRestaurantContract.Presenter {

    private AddFavRestaurantModel model;
    private RestaurantAdapter view;

    public AddFavRestaurantPresenter(RestaurantAdapter view) {
        this.view = view;
        this.model = new AddFavRestaurantModel(view.getContext());
    }

    @Override
    public void addFavRestaurant(FavRestaurant favRestaurant) {
        boolean done = model.addFavRestaurant(favRestaurant);
        if (done) {
            view.showMessage("Restaurant added to favourites");
        } else {
            view.showError("An error success");
        }
    }
}

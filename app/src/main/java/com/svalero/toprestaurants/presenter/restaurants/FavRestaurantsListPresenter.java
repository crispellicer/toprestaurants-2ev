package com.svalero.toprestaurants.presenter.restaurants;

import com.svalero.toprestaurants.contract.restaurants.FavRestaurantsListContract;
import com.svalero.toprestaurants.domain.FavRestaurant;
import com.svalero.toprestaurants.model.restaurants.FavRestaurantsListModel;
import com.svalero.toprestaurants.view.restaurants.FavRestaurantsListView;

import java.util.List;

public class FavRestaurantsListPresenter implements FavRestaurantsListContract.Presenter {

    private FavRestaurantsListModel model;
    private FavRestaurantsListView view;

    public FavRestaurantsListPresenter(FavRestaurantsListView view) {
        this.view = view;
        this.model = new FavRestaurantsListModel(view.getApplicationContext());
    }

    @Override
    public void loadAllFavRestaurants() {
        List<FavRestaurant> favRestaurants  = model.loadAllFavRestaurants();
        view.showFavRestaurants(favRestaurants);
    }
}

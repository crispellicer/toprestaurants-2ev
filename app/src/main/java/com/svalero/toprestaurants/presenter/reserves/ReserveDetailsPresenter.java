package com.svalero.toprestaurants.presenter.reserves;

import com.svalero.toprestaurants.contract.reserves.ReserveDetailsContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.domain.Restaurant;
import com.svalero.toprestaurants.model.customers.CustomerDetailsModel;
import com.svalero.toprestaurants.model.reserves.ReserveDetailsModel;
import com.svalero.toprestaurants.model.restaurants.RestaurantDetailsModel;
import com.svalero.toprestaurants.view.reserves.ReserveDetailsView;

public class ReserveDetailsPresenter implements ReserveDetailsContract.Presenter {

    private ReserveDetailsModel reserveDetailsModel;
    private CustomerDetailsModel customerDetailsModel;
    private RestaurantDetailsModel restaurantDetailsModel;
    private ReserveDetailsView view;

    public ReserveDetailsPresenter(ReserveDetailsView view) {
        reserveDetailsModel = new ReserveDetailsModel(view.getApplicationContext());
        customerDetailsModel = new CustomerDetailsModel(view.getApplicationContext());
        restaurantDetailsModel = new RestaurantDetailsModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadReserve(long id) {
        Reserve reserve = reserveDetailsModel.getReserve(id);
        Customer customer = customerDetailsModel.getCustomerById(reserve.getCustomerId());
        Restaurant restaurant = restaurantDetailsModel.getRestaurantById(reserve.getRestaurantId());
        view.showReserve (reserve, customer, restaurant);
    }
}

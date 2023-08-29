package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.contract.customers.CustomerDetailsContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.CustomerDetailsModel;
import com.svalero.toprestaurants.view.customers.CustomerDetailsView;

public class CustomerDetailsPresenter implements CustomerDetailsContract.Presenter {

    private CustomerDetailsModel model;
    private CustomerDetailsView view;

    public CustomerDetailsPresenter(CustomerDetailsView view) {
        model = new CustomerDetailsModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void loadCustomer(String name) {
        Customer customer = model.getCustomerByName(name);
        view.showCustomer(customer);
    }
}

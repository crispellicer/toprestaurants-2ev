package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.contract.customers.CustomersListContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.CustomersListModel;
import com.svalero.toprestaurants.view.customers.CustomersListView;

import java.util.List;

public class CustomersListPresenter implements CustomersListContract.Presenter,
    CustomersListContract.Model.OnLoadCustomersListener{

    private CustomersListModel model;
    private CustomersListView view;

    public CustomersListPresenter(CustomersListView view) {
        this.view = view;
        this.model = new CustomersListModel(view.getApplicationContext());

    }

    @Override
    public void loadAllCustomers() {
        model.loadAllCustomers(this);
    }

    @Override
    public void loadCustomersByName(String name) {

    }

    @Override
    public void deleteCustomer(String name) {

    }

    @Override
    public void onLoadCustomersSuccess(List<Customer> customers) {
        view.showCustomers(customers);
    }

    @Override
    public void onLoadCustomersError(String message) {
        view.showMessage(message);
    }
}

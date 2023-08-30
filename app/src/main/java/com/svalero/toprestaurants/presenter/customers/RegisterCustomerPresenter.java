package com.svalero.toprestaurants.presenter.customers;

import androidx.annotation.NonNull;

import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.RegisterCustomerModel;
import com.svalero.toprestaurants.view.customers.RegisterCustomerView;

public class RegisterCustomerPresenter implements RegisterCustomerContract.Presenter,
    RegisterCustomerContract.Model.OnRegisterCustomerListener {

    private RegisterCustomerModel model;
    private RegisterCustomerView view;

    public RegisterCustomerPresenter(RegisterCustomerView view) {
        model = new RegisterCustomerModel();
        this.view = view;
    }

    @Override
    public void registerCustomer(Customer customer) {
        model.registerCustomer(customer, this);
    }

    @Override
    public void onRegisterSuccess(Customer customer) {
        view.showMessage("Customer " + customer.getName() + " has been registered");
    }

    @Override
    public void onRegisterError(String message) {
        view.showError("An error has occurred");
    }
}

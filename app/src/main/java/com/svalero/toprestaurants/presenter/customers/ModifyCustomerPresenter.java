package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.ModifyCustomerModel;
import com.svalero.toprestaurants.view.customers.ModifyCustomerView;

public class ModifyCustomerPresenter implements ModifyCustomerContract.Presenter,
        ModifyCustomerContract.Model.OnModifyCustomerListener {

    private ModifyCustomerModel model;
    private ModifyCustomerView view;

    public ModifyCustomerPresenter(ModifyCustomerView view) {
        this.model = new ModifyCustomerModel();
        this.view = view;
    }

    @Override
    public void modifyCustomer(long id, Customer customer) {
        model.modifyCustomer(id, customer, this);
    }

    @Override
    public void onModifySuccess(Customer customer) {
        view.showMessage("The customer has been successfully modified");
    }

    @Override
    public void onModifyError(String message) {
        view.showError("An error has occurred");
    }
}

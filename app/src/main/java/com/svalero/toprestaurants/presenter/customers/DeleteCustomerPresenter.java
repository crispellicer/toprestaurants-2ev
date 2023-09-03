package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.adapter.CustomerAdapter;
import com.svalero.toprestaurants.contract.customers.DeleteCustomerContract;
import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.DeleteCustomerModel;
import com.svalero.toprestaurants.model.customers.RegisterCustomerModel;
import com.svalero.toprestaurants.view.customers.RegisterCustomerView;

public class DeleteCustomerPresenter implements DeleteCustomerContract.Presenter,
    DeleteCustomerContract.Model.OnDeleteCustomerListener {

    private DeleteCustomerModel model;
    private CustomerAdapter view;

    public DeleteCustomerPresenter(CustomerAdapter view) {
        model = new DeleteCustomerModel();
        this.view = view;
    }

    @Override
    public void deleteCustomer(long id) {
        model.deleteCustomer(id, this);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("Customer has been successfully removed");
    }

    @Override
    public void onDeleteError(String message) {
        view.showError("An error has occurred");
    }
}

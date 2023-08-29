package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.ModifyCustomerModel;
import com.svalero.toprestaurants.view.customers.ModifyCustomerView;

public class ModifyCustomerPresenter implements ModifyCustomerContract.Presenter, ModifyCustomerContract.Model.OnModifyUserListener {

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
        view.showMessage("El cliente se ha modificado correctamente");
    }

    @Override
    public void onModifyError(String message) {
        view.showError("Se ha producido un error al modificar el cliente");
    }
}

package com.svalero.toprestaurants.presenter.customers;

import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.model.customers.RegisterCustomerModel;
import com.svalero.toprestaurants.view.customers.RegisterCustomerView;

public class RegisterCustomerPresenter implements RegisterCustomerContract.Presenter {

    private RegisterCustomerModel model;
    private RegisterCustomerView view;

    public RegisterCustomerPresenter(RegisterCustomerView view) {
        model = new RegisterCustomerModel(view.getApplicationContext());
        this.view = view;
    }

    @Override
    public void registerCustomer(Customer customer) {
        boolean done = model.registerCustomer(customer);
        if (done) {
            view.showMessage("Cliente registrado correctamente");
            view.resetForm();
        } else {
            view.showError("Se ha producido un error al registrar el cliente. Comprueba que los datos son correctos");
        }
    }
}

package com.svalero.toprestaurants.model.customers;

import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.customers.ModifyCustomerPresenter;

public class ModifyCustomerModel implements ModifyCustomerContract.Model {

    private ModifyCustomerPresenter presenter;

    @Override
    public void modifyCustomer(long id, Customer customer, OnModifyUserListener listener) {

    }
}

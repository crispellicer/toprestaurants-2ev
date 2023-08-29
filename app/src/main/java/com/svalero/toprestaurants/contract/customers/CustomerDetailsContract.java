package com.svalero.toprestaurants.contract.customers;

import com.svalero.toprestaurants.domain.Customer;

public interface CustomerDetailsContract {

    interface Model {
        Customer getCustomerByName(String name);
        Customer getCustomerById(long id);
    }

    interface View {
        void showCustomer(Customer customer);
    }

    interface Presenter {
        void loadCustomer(String name);
    }
}

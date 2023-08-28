package com.svalero.toprestaurants.contract;

import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

public interface CustomersListContract {

    interface Model {
        List<Customer> loadAllCustomers();
        List<Customer> loadCustomersByName(String name);
        boolean deleteCustomer(String name);
    }

    interface View {
        void showCustomers(List<Customer> customers);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllCustomers();
        void loadCustomersByName(String name);
        void deleteCustomer(String name);
    }
}

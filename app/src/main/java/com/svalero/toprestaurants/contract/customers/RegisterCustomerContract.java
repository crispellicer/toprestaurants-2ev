package com.svalero.toprestaurants.contract.customers;

import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

public interface RegisterCustomerContract {

    interface Model {
        interface OnRegisterCustomerListener {
            void onRegisterSuccess(Customer customer);
            void onRegisterError(String message);
        }
        void registerCustomer(Customer customer, OnRegisterCustomerListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm();
    }

    interface Presenter {
        void registerCustomer(Customer customer);
    }
}

package com.svalero.toprestaurants.contract.customers;

import com.svalero.toprestaurants.domain.Customer;

public interface ModifyCustomerContract {

    interface Model {
        interface OnModifyUserListener {
            void onModifySuccess(Customer customer);
            void onModifyError(String message);
        }
        void modifyCustomer (long id, Customer customer, ModifyCustomerContract.Model.OnModifyUserListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void modifyCustomer(long id, Customer customer);
    }
}

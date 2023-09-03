package com.svalero.toprestaurants.contract.customers;


public interface DeleteCustomerContract {

    interface Model {
        interface OnDeleteCustomerListener {
            void onDeleteSuccess();
            void onDeleteError(String message);
        }
        void deleteCustomer(long id, OnDeleteCustomerListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void deleteCustomer(long id);
    }
}

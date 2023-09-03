package com.svalero.toprestaurants.model.customers;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.customers.ModifyCustomerContract;
import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.presenter.customers.ModifyCustomerPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifyCustomerModel implements ModifyCustomerContract.Model {

    private ModifyCustomerPresenter presenter;

    @Override
    public void modifyCustomer(long id, Customer customer, OnModifyCustomerListener listener) {

        try {
            TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
            Call<Customer> callCustomers = topRestaurantsApi.modifyCustomer(id, customer);
            callCustomers.enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {
                    listener.onModifySuccess(customer);
                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error al invocar la operación";
                    listener.onModifyError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}

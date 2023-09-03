package com.svalero.toprestaurants.model.customers;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterCustomerModel implements RegisterCustomerContract.Model {

    @Override
    public void registerCustomer(Customer customer, OnRegisterCustomerListener listener) {
        try {
            TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
            Call<Customer> callCustomers = topRestaurantsApi.addCustomer(customer);
            callCustomers.enqueue(new Callback<Customer>() {
                @Override
                public void onResponse(Call<Customer> call, Response<Customer> response) {
                    Customer customer = response.body();
                    listener.onRegisterSuccess(customer);

                }

                @Override
                public void onFailure(Call<Customer> call, Throwable t) {
                    String message = "Error invocando a la operación";
                    listener.onRegisterError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}

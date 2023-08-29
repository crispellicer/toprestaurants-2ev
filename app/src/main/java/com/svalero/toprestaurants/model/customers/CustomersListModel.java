package com.svalero.toprestaurants.model.customers;


import android.content.Context;


import com.svalero.toprestaurants.api.TopRestaurantsApi;
import com.svalero.toprestaurants.api.TopRestaurantsApiInterface;
import com.svalero.toprestaurants.contract.customers.CustomersListContract;
import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomersListModel implements CustomersListContract.Model {

    private Context context;

    public CustomersListModel(Context context) {
        this.context = context;
    }

    @Override
    public void loadAllCustomers(OnLoadCustomersListener listener) {
        TopRestaurantsApiInterface topRestaurantsApi = TopRestaurantsApi.buildInstance();
        Call<List<Customer>> callCustomers = topRestaurantsApi.getCustomers();
        callCustomers.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                List<Customer> customers = response.body();
                listener.onLoadCustomersSuccess(customers);

            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                String message = "Error invocando a la operación";
                listener.onLoadCustomersError(message);
            }
        });
    }

    @Override
    public List<Customer> loadCustomersByName(String name) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String name) {
        return false;
    }
}

package com.svalero.toprestaurants.model.customers;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.customers.CustomersListContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Customer;

import java.util.List;

public class CustomersListModel implements CustomersListContract.Model {

    private Context context;

    public CustomersListModel(Context context) {
        this.context = context;
    }
    @Override
    public List<Customer> loadAllCustomers() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.customerDao().getAll();
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

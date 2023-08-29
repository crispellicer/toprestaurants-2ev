package com.svalero.toprestaurants.model.customers;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.customers.CustomerDetailsContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Customer;

public class CustomerDetailsModel implements CustomerDetailsContract.Model {

    private Context context;

    public CustomerDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public Customer getCustomerByName(String name) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.customerDao().getByName(name);
    }

    @Override
    public Customer getCustomerById(long id) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.customerDao().getById(id);
    }
}

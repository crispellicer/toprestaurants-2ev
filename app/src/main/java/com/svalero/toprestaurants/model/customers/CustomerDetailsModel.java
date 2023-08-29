package com.svalero.toprestaurants.model.customers;


import android.content.Context;

import com.svalero.toprestaurants.contract.customers.CustomerDetailsContract;
import com.svalero.toprestaurants.domain.Customer;

public class CustomerDetailsModel implements CustomerDetailsContract.Model {

    private Context context;

    public CustomerDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public Customer getCustomerByName(String name) {
        //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //return db.customerDao().getByName(name);
        return null;
    }

    @Override
    public Customer getCustomerById(long id) {
        //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //return db.customerDao().getById(id);
        return null;
    }
}

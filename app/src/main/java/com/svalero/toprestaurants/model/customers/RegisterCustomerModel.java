package com.svalero.toprestaurants.model.customers;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.customers.RegisterCustomerContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Customer;

public class RegisterCustomerModel implements RegisterCustomerContract.Model {

    private Context context;

    public RegisterCustomerModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean registerCustomer(Customer customer) {
        try {
            final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
            db.customerDao().insert(customer);
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}

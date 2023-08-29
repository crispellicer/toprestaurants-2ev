package com.svalero.toprestaurants.model.reserves;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.svalero.toprestaurants.contract.reserves.RegisterReserveContract;
import com.svalero.toprestaurants.domain.Reserve;

public class RegisterReserveModel implements RegisterReserveContract.Model {

    private Context context;

    public RegisterReserveModel(Context context) {
        this.context = context;
    }
    @Override
    public boolean registerReserve(Reserve reserve) {
        try {
            //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
              //      .allowMainThreadQueries().build();
            //db.reserveDao().insert(reserve);
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}

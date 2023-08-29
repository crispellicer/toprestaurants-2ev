package com.svalero.toprestaurants.model.reserves;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.reserves.ReserveDetailsContract;
import com.svalero.toprestaurants.domain.Reserve;

public class ReserveDetailsModel implements ReserveDetailsContract.Model {

    private Context context;

    public ReserveDetailsModel(Context context) {
        this.context = context;
    }

    @Override
    public Reserve getReserve(long id) {
        //final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
          //      .allowMainThreadQueries().build();
        //return db.reserveDao().getById(id);
        return null;
    }
}

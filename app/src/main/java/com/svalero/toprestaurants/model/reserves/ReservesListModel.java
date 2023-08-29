package com.svalero.toprestaurants.model.reserves;

import static com.svalero.toprestaurants.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.toprestaurants.contract.reserves.ReservesListContract;
import com.svalero.toprestaurants.db.AppDatabase;
import com.svalero.toprestaurants.domain.Reserve;

import java.util.List;

public class ReservesListModel implements ReservesListContract.Model {

    private Context context;

    public ReservesListModel(Context context) {
        this.context = context;
    }

    @Override
    public List<Reserve> loadAllReserves() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.reserveDao().getAll();
    }

    @Override
    public boolean deleteReserve(String name) {
        return false;
    }
}

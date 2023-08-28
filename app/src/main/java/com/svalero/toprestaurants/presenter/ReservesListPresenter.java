package com.svalero.toprestaurants.presenter;

import com.svalero.toprestaurants.contract.ReservesListContract;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.model.ReservesListModel;
import com.svalero.toprestaurants.view.reserves.ReservesListView;

import java.util.List;

public class ReservesListPresenter implements ReservesListContract.Presenter {

    private ReservesListModel model;
    private ReservesListView view;

    public ReservesListPresenter(ReservesListView view) {
        this.view = view;
        this.model = new ReservesListModel(view.getApplicationContext());

    }

    @Override
    public void loadAllReserves() {
        List<Reserve> reserves = model.loadAllReserves();
        view.showReserves(reserves);
    }

    @Override
    public void loadReservesByName(String name) {

    }

    @Override
    public void deleteReserve(String name) {

    }
}

package com.svalero.toprestaurants.presenter.reserves;

import com.svalero.toprestaurants.contract.reserves.ReservesListContract;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.model.reserves.ReservesListModel;
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

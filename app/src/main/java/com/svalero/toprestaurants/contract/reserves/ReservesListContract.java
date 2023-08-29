package com.svalero.toprestaurants.contract.reserves;

import com.svalero.toprestaurants.domain.Reserve;

import java.util.List;

public interface ReservesListContract {

    interface Model {
        List<Reserve> loadAllReserves();
        boolean deleteReserve(String name);
    }

    interface View {
        void showReserves(List<Reserve> reserves);

        void showMessage(String message);
    }

    interface Presenter {
        void loadAllReserves();
        void loadReservesByName(String name);
        void deleteReserve(String name);
    }
}

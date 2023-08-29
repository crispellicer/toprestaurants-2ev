package com.svalero.toprestaurants.contract.reserves;

import com.svalero.toprestaurants.domain.Reserve;

public interface RegisterReserveContract {

    interface Model {
        boolean registerReserve(Reserve reserve);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm();
    }

    interface Presenter {
        void registerReserve(Reserve reserve);
    }
}

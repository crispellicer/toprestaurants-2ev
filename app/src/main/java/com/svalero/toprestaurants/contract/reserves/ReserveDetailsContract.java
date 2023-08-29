package com.svalero.toprestaurants.contract.reserves;

import com.svalero.toprestaurants.domain.Customer;
import com.svalero.toprestaurants.domain.Reserve;
import com.svalero.toprestaurants.domain.Restaurant;

public interface ReserveDetailsContract {

    interface Model {
        Reserve getReserve(long id);
    }

    interface View {
        void showReserve(Reserve reserve, Customer customer, Restaurant restaurant);
    }

    interface Presenter {
        void loadReserve(long id);
    }
}
